package de.suborskar.samlet.iogr;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class IOGRRequest{
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

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getLogic() {
        return logic;
    }

    public void setLogic(int logic) {
        this.logic = logic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(int startLocation) {
        this.startLocation = startLocation;
    }

    public int getStatueReq() {
        return statueReq;
    }

    public void setStatueReq(int statueReq) {
        this.statueReq = statueReq;
    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

    public boolean isAllowGlitches() {
        return allowGlitches;
    }

    public void setAllowGlitches(boolean allowGlitches) {
        this.allowGlitches = allowGlitches;
    }

    public boolean isBossShuffle() {
        return bossShuffle;
    }

    public void setBossShuffle(boolean bossShuffle) {
        this.bossShuffle = bossShuffle;
    }

    public boolean isDungeonShuffle() {
        return dungeonShuffle;
    }

    public void setDungeonShuffle(boolean dungeonShuffle) {
        this.dungeonShuffle = dungeonShuffle;
    }

    public int getEnemizer() {
        return enemizer;
    }

    public void setEnemizer(int enemizer) {
        this.enemizer = enemizer;
    }

    public int getEntranceShuffle() {
        return entranceShuffle;
    }

    public void setEntranceShuffle(int entranceShuffle) {
        this.entranceShuffle = entranceShuffle;
    }

    public boolean isFirebird() {
        return firebird;
    }

    public void setFirebird(boolean firebird) {
        this.firebird = firebird;
    }

    public boolean isFluteless() {
        return fluteless;
    }

    public void setFluteless(boolean fluteless) {
        this.fluteless = fluteless;
    }

    public boolean isGenerateRaceRom() {
        return generateRaceRom;
    }

    public void setGenerateRaceRom(boolean generateRaceRom) {
        this.generateRaceRom = generateRaceRom;
    }

    public boolean isHideSettings() {
        return hideSettings;
    }

    public void setHideSettings(boolean hideSettings) {
        this.hideSettings = hideSettings;
    }

    public boolean isOhko() {
        return ohko;
    }

    public void setOhko(boolean ohko) {
        this.ohko = ohko;
    }

    public boolean isOpenMode() {
        return openMode;
    }

    public void setOpenMode(boolean openMode) {
        this.openMode = openMode;
    }

    public boolean isOverworldShuffle() {
        return overworldShuffle;
    }

    public void setOverworldShuffle(boolean overworldShuffle) {
        this.overworldShuffle = overworldShuffle;
    }

    public boolean isRedJewelMadness() {
        return redJewelMadness;
    }

    public void setRedJewelMadness(boolean redJewelMadness) {
        this.redJewelMadness = redJewelMadness;
    }

    public boolean isZ3Mode() {
        return z3Mode;
    }

    public void setZ3Mode(boolean z3Mode) {
        this.z3Mode = z3Mode;
    }
}
