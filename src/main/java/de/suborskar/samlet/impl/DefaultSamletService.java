package de.suborskar.samlet.impl;

import de.suborskar.samlet.SamletService;
import de.suborskar.samlet.configuration.SamletConfiguration;
import de.suborskar.samlet.iogr.IOGRClient;
import de.suborskar.samlet.iogr.IOGRResponse;
import de.suborskar.samlet.parser.ParserResult;
import de.suborskar.samlet.parser.ParsingError;
import de.suborskar.samlet.parser.QueryParser;
import jakarta.inject.Singleton;

import java.util.stream.Collectors;

@Singleton
public class DefaultSamletService implements SamletService {
    private IOGRClient iogrClient;

    private SamletConfiguration samletConfiguration;

    private QueryParser queryParser;

    public DefaultSamletService(final IOGRClient iogrClient, final SamletConfiguration samletConfiguration, final QueryParser queryParser) {
        this.iogrClient = iogrClient;
        this.samletConfiguration = samletConfiguration;
        this.queryParser = queryParser;
    }

    public String getSeed(final String query) {
        final ParserResult parserResult = queryParser.parse(query);
        if (parserResult.hasErrors()) {
            return "Nice try dodongo!\n"
                    + parserResult.errors().stream().map(ParsingError::msg).collect(Collectors.joining("\n"));
        }
        final IOGRResponse resp = iogrClient.getSeed(parserResult.request());
        return samletConfiguration.getWebUrl() + "/permalink/" + resp.getPermalinkId();
    }
}
