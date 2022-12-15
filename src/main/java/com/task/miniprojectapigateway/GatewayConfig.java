package com.task.miniprojectapigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

    @Autowired
    private AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().
                route("auth", r -> r.path("/api/auth/**")
                    .filters(f -> f.filter(filter))
                    .uri("lb://REGISTRATION")).

                route("registration", r -> r.path("/registration/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://REGISTRATION")).

                route("tasks", r -> r.path("/v1/tasks/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://TASK-SERVICE")).

                route("task-service", r -> r.path("/task-service/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://TASK-SERVICE"))
                .build();
    }


}
