package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.parser.FlagParser;
import de.suborskar.samlet.parser.ParsingError;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class Zelda3ModeFlagParser implements FlagParser {
    @Override
    public boolean canParse(final String flag) {
        return "z3".equals(flag) || "zelda3".equalsIgnoreCase(flag) || "zelda3mode".equalsIgnoreCase(flag);
    }

    @Override
    public void parse(final String flag, final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        builder.z3Mode(true);
    }
}
