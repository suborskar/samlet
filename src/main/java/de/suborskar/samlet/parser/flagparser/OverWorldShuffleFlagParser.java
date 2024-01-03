package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.parser.FlagParser;
import de.suborskar.samlet.parser.ParsingError;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class OverWorldShuffleFlagParser implements FlagParser {
    @Override
    public boolean canParse(final String flag) {
        return "w".equals(flag) || "overworld".equalsIgnoreCase(flag) || "overworldshuffle".equalsIgnoreCase(flag);
    }

    @Override
    public void parse(final String flag, final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        builder.overworldShuffle(true);
    }
}
