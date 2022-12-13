package com.task.miniprojectapigateway;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RouteValidator {
    public static final List<String> openApiEndpoints= Arrays.asList("/api/auth/signin", "/api/auth/signup");

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
