package de.suborskar.samlet;

public interface SamletService {
    /**
     *
      * @param query query String for the Seed
     * @return The message, Samlet sends to DC
     */
    String getSeed(String query);
}
