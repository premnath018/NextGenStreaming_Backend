package com.nextgen.cassandra_db;

import com.nextgen.cassandra_db.Connection.DataStaxAstraProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class CassandraDbApplication {

	@Value("${spring.data.cassandra.username}")
	private String cassandraUsername;

	@Value("${spring.data.cassandra.password}")
	private String cassandraPassword;

	public static void main(String[] args) {
		SpringApplication.run(CassandraDbApplication.class, args);
	}

	/**
	 * This is necessary to have the Spring Boot app use the Astra secure bundle
	 * to connect to the database
	 */

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle)
		.withAuthCredentials(cassandraUsername,cassandraPassword);

	}

}
