package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.function.Consumer;

@Singleton
public class LogicFlagParser extends MappedFlagParser {
    private static final Consumer<IOGRRequest.Builder> BEATABLE = b -> b.logic(1);
    private static final Consumer<IOGRRequest.Builder> CHAOS = b -> b.logic(2);

    private final Map<String, Consumer<IOGRRequest.Builder>> flagMap = Map.of(
            "L(b)", BEATABLE,
            "L(x)", CHAOS,
            "beatable", BEATABLE,
            "chaos", CHAOS
    );

    @Override
    protected Map<String, Consumer<IOGRRequest.Builder>> getFlagMap() {
        return flagMap;
    }
}
