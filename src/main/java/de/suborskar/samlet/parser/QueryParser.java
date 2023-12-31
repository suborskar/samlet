package de.suborskar.samlet.parser;

import jakarta.inject.Singleton;

@Singleton
public class QueryParser {
    public ParserResult parse(String query) {
        return new ParserResult();
    }
}
