package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.parser.FlagParser;
import de.suborskar.samlet.parser.ParsingError;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class RaceModeFlagParser implements FlagParser {
    @Override
    public boolean canParse(final String flag) {
        return "R".equals(flag) || "race".equalsIgnoreCase(flag) || "racemode".equalsIgnoreCase(flag);
    }

    @Override
    public void parse(final String flag, final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        builder.generateRaceRom(true);
    }
}
