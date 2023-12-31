package de.suborskar.samlet.discord.events;

import de.suborskar.samlet.Constants;
import de.suborskar.samlet.SamletService;
import discord4j.core.event.domain.message.MessageCreateEvent;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Objects;

@Singleton
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {

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
                .filter(message -> message.getContent().trim().startsWith(Constants.SEED_COMMAND))
                .publishOn(Schedulers.boundedElastic())
                .flatMap(message -> Objects.requireNonNull(message.getChannel().block()).createMessage(samletService.getSeed(message.getContent())))
                .then();
    }
}