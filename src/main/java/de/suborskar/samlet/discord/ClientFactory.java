package de.suborskar.samlet.discord;

import de.suborskar.samlet.configuration.SamletConfiguration;
import de.suborskar.samlet.discord.events.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

import java.util.List;

@Factory
public class ClientFactory {
    @Singleton
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(final SamletConfiguration samletConfiguration, final List<EventListener<T>> eventListeners) {
        final GatewayDiscordClient client = DiscordClientBuilder.create(samletConfiguration.getToken())
                .build()
                .login()
                .block();
        if(client != null) {
            for (EventListener<T> listener : eventListeners) {
                client.on(listener.getEventType())
                        .flatMap(listener::execute)
                        .onErrorResume(listener::handleError)
                        .subscribe();
            }
        }
        return client;
    }


}
