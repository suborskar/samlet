package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.parser.FlagParser;
import de.suborskar.samlet.parser.ParsingError;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class DifficultyFlagParser implements FlagParser {
    private enum Difficulty {
        EASY, NORMAL, HARD, EXTREME
    }
    @Override
    public boolean canParse(final String flag) {
        try {
            Difficulty.valueOf(flag.toUpperCase());
            return true;
        } catch (final IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public void parse(final String flag, final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        builder.difficulty(Difficulty.valueOf(flag.toUpperCase()).ordinal());
    }
}
