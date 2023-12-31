package de.suborskar.samlet.iogr;

import io.micronaut.serde.annotation.Serdeable;

import java.util.Random;

@Serdeable
public class IOGRRequest {
    private final static Random random = new Random();

    private final long seed;
    private final int goal;
    private final int logic;
    private final int difficulty;
    private final int startLocation;
    private final int statueReq;
    private final String statues;
    private final boolean allowGlitches;
    private final boolean bossShuffle;
    private final boolean dungeonShuffle;
    private final int enemizer;
    private final int entranceShuffle;
    private final boolean firebird;
    private final boolean fluteless;
    private final boolean generateRaceRom;
    private final boolean hideSettings;
    private final boolean ohko;
    private final boolean openMode;
    private final boolean overworldShuffle;
    private final boolean redJewelMadness;
    private final boolean z3Mode;

    private IOGRRequest(final Builder builder) {
        seed = builder.seed;
        goal = builder.goal;
        logic = builder.logic;
        difficulty = builder.difficulty;
        startLocation = builder.startLocation;
        statueReq = builder.statueReq;
        statues = builder.statues;
        allowGlitches = builder.allowGlitches;
        bossShuffle = builder.bossShuffle;
        dungeonShuffle = builder.dungeonShuffle;
        enemizer = builder.enemizer;
        entranceShuffle = builder.entranceShuffle;
        firebird = builder.firebird;
        fluteless = builder.fluteless;
        generateRaceRom = builder.generateRaceRom;
        hideSettings = builder.hideSettings;
        ohko = builder.ohko;
        openMode = builder.openMode;
        overworldShuffle = builder.overworldShuffle;
        redJewelMadness = builder.redJewelMadness;
        z3Mode = builder.z3Mode;
    }

    public long getSeed() {
        return seed;
    }

    public int getGoal() {
        return goal;
    }

    public int getLogic() {
        return logic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getStartLocation() {
        return startLocation;
    }

    public int getStatueReq() {
        return statueReq;
    }

    public String getStatues() {
        return statues;
    }

    public boolean isAllowGlitches() {
        return allowGlitches;
    }

    public boolean isBossShuffle() {
        return bossShuffle;
    }

    public boolean isDungeonShuffle() {
        return dungeonShuffle;
    }

    public int getEnemizer() {
        return enemizer;
    }

    public int getEntranceShuffle() {
        return entranceShuffle;
    }

    public boolean isFirebird() {
        return firebird;
    }

    public boolean isFluteless() {
        return fluteless;
    }

    public boolean isGenerateRaceRom() {
        return generateRaceRom;
    }

    public boolean isHideSettings() {
        return hideSettings;
    }

    public boolean isOhko() {
        return ohko;
    }

    public boolean isOpenMode() {
        return openMode;
    }

    public boolean isOverworldShuffle() {
        return overworldShuffle;
    }

    public boolean isRedJewelMadness() {
        return redJewelMadness;
    }

    public boolean isZ3Mode() {
        return z3Mode;
    }

    public static class Builder {
        private long seed;
        private int goal;
        private int logic;
        private int difficulty;
        private int startLocation;
        private int statueReq;
        private String statues;
        private boolean allowGlitches;
        private boolean bossShuffle;
        private boolean dungeonShuffle;
        private int enemizer;
        private int entranceShuffle;
        private boolean firebird;
        private boolean fluteless;
        private boolean generateRaceRom;
        private boolean hideSettings;
        private boolean ohko;
        private boolean openMode;
        private boolean overworldShuffle;
        private boolean redJewelMadness;
        private boolean z3Mode;

        public Builder() {
            seed = generateRandomSeedValue();
            difficulty = 1;
            statues = "4";
        }

        public IOGRRequest build() {
            return new IOGRRequest(this);
        }

        public Builder withSeed(final long seed) {
            this.seed = seed;
            return this;
        }

        public Builder withGoal(final int goal) {
            this.goal = goal;
            return this;
        }

        public Builder withLogic(final int logic) {
            this.logic = logic;
            return this;
        }

        public Builder withDifficulty(final int difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Builder withStartLocation(final int startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public Builder withStatueReq(final int statueReq) {
            this.statueReq = statueReq;
            return this;
        }

        public Builder withStatues(final String statues) {
            this.statues = statues;
            return this;
        }

        public Builder withAllowGlitches(final boolean allowGlitches) {
            this.allowGlitches = allowGlitches;
            return this;
        }

        public Builder withBossShuffle(final boolean bossShuffle) {
            this.bossShuffle = bossShuffle;
            return this;
        }

        public Builder withDungeonShuffle(final boolean dungeonShuffle) {
            this.dungeonShuffle = dungeonShuffle;
            return this;
        }

        public Builder withEnemizer(final int enemizer) {
            this.enemizer = enemizer;
            return this;
        }

        public Builder withEntranceShuffle(final int entranceShuffle) {
            this.entranceShuffle = entranceShuffle;
            return this;
        }

        public Builder withFirebird(final boolean firebird) {
            this.firebird = firebird;
            return this;
        }

        public Builder withFluteless(final boolean fluteless) {
            this.fluteless = fluteless;
            return this;
        }

        public Builder withGenerateRaceRom(final boolean generateRaceRom) {
            this.generateRaceRom = generateRaceRom;
            return this;
        }

        public Builder withHidewithtings(final boolean hideSettings) {
            this.hideSettings = hideSettings;
            return this;
        }

        public Builder withOhko(final boolean ohko) {
            this.ohko = ohko;
            return this;
        }

        public Builder withOpenMode(final boolean openMode) {
            this.openMode = openMode;
            return this;
        }

        public Builder withOverworldShuffle(final boolean overworldShuffle) {
            this.overworldShuffle = overworldShuffle;
            return this;
        }

        public Builder withRedJewelMadness(final boolean redJewelMadness) {
            this.redJewelMadness = redJewelMadness;
            return this;
        }

        public Builder withZ3Mode(final boolean z3Mode) {
            this.z3Mode = z3Mode;
            return this;
        }

        private long generateRandomSeedValue() {
            final Long max = 2147483648L;
            final int min = 0;

            return random.nextLong() * (max - min + 1) + min;
        }
    }
}
