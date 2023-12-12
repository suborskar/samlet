package de.suborskar.samlet.discord.events;

import de.suborskar.samlet.configuration.SamletConfiguration;
import de.suborskar.samlet.iogr.IOGRClient;
import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.iogr.IOGRResponse;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.util.Random;

@Singleton
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {

    private IOGRClient iogrClient;

    private SamletConfiguration samletConfiguration;

    private Random random = new Random();

    public MessageCreateListener(IOGRClient iogrClient, SamletConfiguration samletConfiguration) {
        this.iogrClient = iogrClient;
        this.samletConfiguration = samletConfiguration;
    }

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {

        return Mono.just(event.getMessage())
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().equalsIgnoreCase("!iogr-seed"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(getSeedLink()))
                .then();
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