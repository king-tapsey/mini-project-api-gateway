package com.task.miniprojectapigateway;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Registration Service API")
                .description("REST API to get end points for registering to the TODO app.")
                .version("2.0")
                .contact(apiContact())
                .license(apiLicense());
    }

    private License apiLicense() {
        return new License()
                .name("MIT License")
                .url("#");
    }

    private Contact apiContact() {
        return new Contact()
                .name("AfroSoft Developers")
                .email("noreply@afrosoft.co.zw")
                .url("#");
    }

}
