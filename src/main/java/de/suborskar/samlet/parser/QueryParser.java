package de.suborskar.samlet.parser;

import de.suborskar.samlet.Constants;
import de.suborskar.samlet.iogr.IOGRRequest;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class QueryParser {
    private final List<FlagParser> flagParsers;
    public  QueryParser(final List<FlagParser> flagParsers) {
        this.flagParsers = flagParsers;
    }

    public ParserResult parse(final String query) {
        final List<ParsingError> errors = new ArrayList<>();
        final IOGRRequest.Builder iogrRequestBuilder = new IOGRRequest.Builder();
        final String q = query.trim().startsWith(Constants.SEED_COMMAND)?query.trim().substring(Constants.SEED_COMMAND.length()).trim() : query.trim();
        if (StringUtils.isNotEmpty(q)) {
            for (final String flag : q.split(" ")) {
                parseFlag(flag, iogrRequestBuilder, errors);
            }
        }
        return new ParserResult(iogrRequestBuilder.build(), errors);
    }

    private void parseFlag(final String flag, final IOGRRequest.Builder iogrRequestBuilder, final List<ParsingError> errors) {
        for (final FlagParser flagParser : flagParsers) {
            if (flagParser.canParse(flag)) {
                flagParser.parse(flag, iogrRequestBuilder, errors);
                return;
            }
        }
        errors.add(new ParsingError("Unknown flag \"" + flag + "\""));
    }
}
