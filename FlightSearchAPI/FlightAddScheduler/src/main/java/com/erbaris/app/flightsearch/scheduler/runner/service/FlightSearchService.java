package com.erbaris.app.flightsearch.scheduler.runner.service;

import com.erbaris.app.flightsearch.scheduler.runner.entity.FlightDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.*;
import java.nio.charset.StandardCharsets;

@Service
@Scope("prototype")
public class FlightSearchService {
    private final RestTemplate m_restTemplate;

    @Value("${app.flightsearch.url}")
    private String m_url;

    public FlightSearchService(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }
    public FlightDTO generateAndSaveRandomFlight() {

        m_restTemplate.setRequestFactory(new BasicAuthRequestFactory("baris", "12345"));

        return m_restTemplate.getForObject(m_url, FlightDTO.class);

    }
    private static class BasicAuthRequestFactory extends SimpleClientHttpRequestFactory {

        private final String username;
        private final String password;

        public BasicAuthRequestFactory(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
            try {
                super.prepareConnection(connection, httpMethod);
            } catch (Exception ignored) {

            }

            String base64Credentials = new String(
                    org.springframework.security.crypto.codec.Base64.encode((username + ":" + password).getBytes(StandardCharsets.UTF_8)),
                    StandardCharsets.UTF_8
            );

            connection.setRequestProperty("Authorization", "Basic " + base64Credentials);
        }

    }
}
