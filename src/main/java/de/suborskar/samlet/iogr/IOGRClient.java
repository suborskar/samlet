package de.suborskar.samlet.iogr;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.suborskar.samlet.configuration.SamletConfiguration;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Singleton
public class IOGRClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOGRClient.class);
    public static final String SEED_GENERATION_PATH = "seed/generate";

    private HttpClient client;

    private String apiVersion;

    public IOGRClient(final SamletConfiguration samletConfiguration) {
        client = HttpClient.create(samletConfiguration.getApiUrl());
        apiVersion = samletConfiguration.getApiVersion();
    }

    public IOGRResponse getSeed(final IOGRRequest request) {
        final URI uri = UriBuilder.of(apiVersion).path(SEED_GENERATION_PATH).build();
        final HttpRequest<IOGRRequest> req = HttpRequest.POST(uri, request).contentType(MediaType.APPLICATION_JSON_TYPE);
        try {
            final HttpResponse<String> response = client.toBlocking().exchange(req, String.class);
            if (response.getStatus().equals(HttpStatus.OK)) {
                final ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(response.body(), IOGRResponse.class);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}