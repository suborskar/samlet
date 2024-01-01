package de.suborskar.samlet.parser;

import de.suborskar.samlet.iogr.IOGRRequest;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.regex.Pattern;

@Singleton
public class GoalFlagParser implements FlagParser {
    public enum Gaia {
        DG, AG, RG
    }
    final Pattern pattern = Pattern.compile("^((DG|AG|RG)[1-4R][rp]?|RJ)$");

    @Override
    public boolean canParse(String flag) {
        return pattern.matcher(flag).matches();
    }

    @Override
    public void parse(final String flag,final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        if (flag.length() == 2) {
            builder.withGoal(3);
        } else {
            final Gaia gaia = Gaia.valueOf(flag.substring(0, 2));

        }
    }
}
