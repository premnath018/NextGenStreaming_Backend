package com.nextgen.gateway.Filter;

import com.nextgen.gateway.Util.JwtUtil;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.core.io.buffer.DataBuffer;

import java.nio.charset.StandardCharsets;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private RouteValidator validator;
    private JwtUtil jwtUtil;

    @Autowired
    public void setValidator(RouteValidator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setJwtUtil(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                // Check if the header contains the token
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    return onError(exchange, "Missing authorization header", HttpStatus.UNAUTHORIZED);
                }

                String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                } else {
                    return onError(exchange, "Invalid authorization header", HttpStatus.UNAUTHORIZED);
                }

                try {
                    jwtUtil.validateToken(authHeader);
                } catch (Exception e) {
                    return onError(exchange, "Unauthorized access", HttpStatus.UNAUTHORIZED);
                }
            }
            return chain.filter(exchange);
        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, String errorMessage, HttpStatus status) {
        exchange.getResponse().setStatusCode(status);
        byte[] bytes = errorMessage.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }

    public static class Config {
        // Configuration properties can be defined here if needed
    }
}
