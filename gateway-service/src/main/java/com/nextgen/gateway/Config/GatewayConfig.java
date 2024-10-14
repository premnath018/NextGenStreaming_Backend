package com.nextgen.gateway.Config;

import com.nextgen.gateway.Filter.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final AuthenticationFilter authenticationFilter;
    private static final String API_BASE_PATH = "/api/v1";

    public GatewayConfig(AuthenticationFilter authenticationFilter) {
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("home-page", r -> r.path(API_BASE_PATH + "/hview/**")
                        .filters(f -> f
                                .filter(authenticationFilter.apply(new AuthenticationFilter.Config()))
                                .stripPrefix(2) // Strips the 2 segment, i.e., API_BASE_PATH
                        )
                        .uri("lb://HOME-PAGE-SERVICE")) // Load-balancer URL for Eureka service
                // Route for identity-service, using service name from Eureka
                .route("auth-service", r -> r.path(API_BASE_PATH + "/auth/**")
                        .filters(f -> f
                                .stripPrefix(2)) // Strips the 2 segment, i.e., API_BASE_PATH
                        .uri("lb://AUTH-SERVICE")) // Load-balancer URL for Eureka service
                .build();
    }
}
