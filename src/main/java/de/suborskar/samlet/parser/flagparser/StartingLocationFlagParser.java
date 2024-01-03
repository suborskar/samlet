package de.suborskar.samlet.parser.flagparser;

import de.suborskar.samlet.iogr.IOGRRequest;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.function.Consumer;

@Singleton
public class StartingLocationFlagParser extends MappedFlagParser {
    private static final Consumer<IOGRRequest.Builder> SAFE = b -> b.startLocation(1);
    private static final Consumer<IOGRRequest.Builder> UNSAFE = b -> b.startLocation(2);
    private static final Consumer<IOGRRequest.Builder> FORCED_UNSAFE = b -> b.startLocation(3);

    private final Map<String, Consumer<IOGRRequest.Builder>> flagMap = Map.of(
            "S(s)", SAFE,
            "S(u)", UNSAFE,
            "S(f)", FORCED_UNSAFE,
            "save", SAFE,
            "unsave", UNSAFE,
            "UNSAVE", FORCED_UNSAFE
    );


    @Override
    protected Map<String, Consumer<IOGRRequest.Builder>> getFlagMap() {
        return flagMap;
    }
}
