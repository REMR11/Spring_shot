package org.kodigo.jd23.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI jdOpenApi(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("JD - 23 Kodigo org - 2026")
                                .description("Esta es la primera api para el bootcamp java 23")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("KodiJobs professionals")
                                                .email("kodi.jobs@Kodigo.org")
                                )
                                .license(new License()
                                        .name("MIT license")
                                        .url("https://opensource.org/osd"))
                )
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080/")
                                .description("Servidor de desarrollo"),
                        new Server()
                                .url("https://kodigo.org/")
                                .description("Servidor de produccion")
                        )


                );
    }
}
