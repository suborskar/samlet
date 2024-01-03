package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.parser.FlagParser;
import de.suborskar.samlet.parser.ParsingError;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class MappedFlagParser implements FlagParser {
    @Override
    public boolean canParse(final String flag) {
        return getFlagMap().containsKey(flag);
    }

    @Override
    public void parse(final String flag, final IOGRRequest.Builder builder, final List<ParsingError> errors) {
        getFlagMap().get(flag).accept(builder);
    }

    protected abstract Map<String, Consumer<IOGRRequest.Builder>> getFlagMap();
}
