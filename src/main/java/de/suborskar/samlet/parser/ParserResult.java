package de.suborskar.samlet.parser;

import de.suborskar.samlet.iogr.IOGRRequest;

import java.util.List;

public record ParserResult(IOGRRequest request, List<ParsingError> errors) {
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
