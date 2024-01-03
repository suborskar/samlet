package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.function.Consumer;

@Singleton
public class EntranceShuffleFlagParser extends MappedFlagParser {
    private static final Consumer<IOGRRequest.Builder> COUPLED = b -> b.entranceShuffle(1);
    private static final Consumer<IOGRRequest.Builder> UNCOUPLED = b -> b.entranceShuffle(2);

    private final Map<String, Consumer<IOGRRequest.Builder>> flagMap = Map.of(
            "ER", COUPLED,
            "ER(x)", UNCOUPLED,
            "coupled", COUPLED,
            "uncoupled", UNCOUPLED
    );

    @Override
    protected Map<String, Consumer<IOGRRequest.Builder>> getFlagMap() {
        return flagMap;
    }
}
