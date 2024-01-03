package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.function.Consumer;

@Singleton
public class EnemizerFlagParser extends MappedFlagParser {
    private static final Consumer<IOGRRequest.Builder> LIMITED = b -> b.enemizer(1);
    private static final Consumer<IOGRRequest.Builder> BALANCED = b -> b.enemizer(2);
    private static final Consumer<IOGRRequest.Builder> FULL = b -> b.enemizer(3);
    private static final Consumer<IOGRRequest.Builder> INSANE = b -> b.enemizer(4);

    private final Map<String, Consumer<IOGRRequest.Builder>> flagMap = Map.of(
            "E(b)", BALANCED,
            "E(l)", LIMITED,
            "E(f)", FULL,
            "E(i)", INSANE,
            "balanced", BALANCED,
            "limited", LIMITED,
            "full", FULL,
            "insane", INSANE
    );

    @Override
    protected Map<String, Consumer<IOGRRequest.Builder>> getFlagMap() {
        return flagMap;
    }
}