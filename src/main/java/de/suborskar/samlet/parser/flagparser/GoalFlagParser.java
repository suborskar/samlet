package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.parser.FlagParser;
import de.suborskar.samlet.parser.ParsingError;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.regex.Pattern;

@Singleton
public class GoalFlagParser implements FlagParser {
    private enum Gaia {
        DG, AG, RG
    }

    final Pattern pattern = Pattern.compile("^((DG|AG|RG)[1-6R][rp]?|RJ)$");

    @Override
    public boolean canParse(String flag) {
        return pattern.matcher(flag).matches();
    }

    @Override
    public void parse(final String flag, final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        if (flag.length() == 2) {
            builder.goal(3);
        } else {
            final Gaia gaia = Gaia.valueOf(flag.substring(0, 2));
            builder.goal(gaia.ordinal());

            final String statCount = flag.substring(2, 3);
            builder.statues(StringUtils.isDigits(statCount) ? statCount : "Random");

            if (flag.length() == 4) {
                final String statueReq = flag.substring(3, 4);
                builder.statueReq(statueReq.equals("p") ? 1 : 2);
            }
        }
    }
}
