package de.suborskar.samlet;

import io.micronaut.runtime.Micronaut;

public class Main {
    public static void main(String[] args) {
        Micronaut.build(args).eagerInitSingletons(true).mainClass(Main.class).start();
    }
}