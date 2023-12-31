package de.suborskar.samlet.parser;

import de.suborskar.samlet.iogr.IOGRRequest;

import java.util.List;

public interface FlagParser {
    boolean canParse(String flag);

    void parse(String flag, IOGRRequest.Builder builder, List<ParsingError> errors);
}
