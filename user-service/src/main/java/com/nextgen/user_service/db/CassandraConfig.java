package com.nextgen.user_service.db;

import com.datastax.astra.sdk.AstraClient;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class CassandraConfig {

    @Value("${astra.db.application.token}")
    private String clientToken;

    @Value("${spring.data.cassandra.username}")
    private String clientId;

    @Value("${spring.data.cassandra.password}")
    private String clientSecret;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Value("${spring.data.cassandra.local-datacenter}")
    private String datacenter;

    @Value("${astra.db.id}")
    private String databaseId;

    @Bean
    public CqlSession cqlSession() {

        try (AstraClient astraClient = AstraClient.builder()
                .withToken(clientToken)
                .withClientId(clientId)
                .withClientSecret(clientSecret)
                .withDatabaseId(databaseId)
                .withDatabaseRegion(datacenter)
                .withCqlKeyspace(keyspaceName)
                .enableCql()
                .build()) {

            return astraClient.cqlSession();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Astra connection", e);
        }
    }
}
