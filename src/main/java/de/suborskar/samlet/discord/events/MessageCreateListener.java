package de.suborskar.samlet.discord.events;

import de.suborskar.samlet.SamletService;
import de.suborskar.samlet.configuration.SamletConfiguration;
import de.suborskar.samlet.iogr.IOGRClient;
import de.suborskar.samlet.iogr.IOGRRequest;
import de.suborskar.samlet.iogr.IOGRResponse;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Objects;
import java.util.Random;

@Singleton
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {
    public static final String SEED_COMMAND = "!iogr";

    private SamletService samletService;

    public MessageCreateListener(SamletService samletService) {
        this.samletService = samletService;
    }

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {

        return Mono.just(event.getMessage())
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().startsWith(SEED_COMMAND))
                .publishOn(Schedulers.boundedElastic())
                .flatMap(message -> Objects.requireNonNull(message.getChannel().block()).createMessage(samletService.getSeed(message.getContent())))
                .then();
    }
}