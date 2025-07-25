package com.programming.techie.gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
  @Bean
  public RouterFunction<ServerResponse> productServiceRoute() {
    return GatewayRouterFunctions.route("product-service")
        .route(RequestPredicates.path("/api/v1/products"), HandlerFunctions
            .http("http://localhost:8080"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> orderServiceRoute() {
    return GatewayRouterFunctions.route("order-service")
        .route(RequestPredicates.path("/api/v1/orders"), HandlerFunctions
            .http("http://localhost:8081"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> inventoryServiceRoute() {
    return GatewayRouterFunctions.route("inventory-service")
        .route(RequestPredicates.path("/api/v1/inventory"), HandlerFunctions
            .http("http://localhost:8082"))
        .build();
  }
}
