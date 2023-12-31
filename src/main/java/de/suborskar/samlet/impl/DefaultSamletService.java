package de.suborskar.samlet.impl;

import de.suborskar.samlet.SamletService;
import de.suborskar.samlet.configuration.SamletConfiguration;
import de.suborskar.samlet.iogr.IOGRClient;
import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.iogr.IOGRResponse;
import jakarta.inject.Singleton;

import java.util.Random;

@Singleton
public class DefaultSamletService implements SamletService {
    private IOGRClient iogrClient;

    private SamletConfiguration samletConfiguration;

    private Random random = new Random();

    public String getSeed(String query){
        return null;
    }

    private String getSeedLink() {
        IOGRRequest req = new IOGRRequest();
        req.setSeed(generateRandomSeedValue());
        req.setDifficulty(1);
        req.setStatues("4");
        IOGRResponse resp = iogrClient.getSeed(req);
        return samletConfiguration.getWebUrl() + "/permalink/" + resp.getPermalinkId();
    }

    private long generateRandomSeedValue() {
        final Long max = 2147483648L;
        final int min = 0;

        return random.nextLong() * (max - min + 1) + min;
    }
}
