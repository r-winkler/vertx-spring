package ch.renewinkler.vertx.example1;

import ch.renewinkler.vertx.example1.echo.EchoServiceVerticle;
import ch.renewinkler.vertx.example1.springwebapp.SpringControllerVerticle;
import io.vertx.core.Vertx;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApp {

    @Bean
    public Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean
    public CommandLineRunner setUp(
            Vertx vertx,
            EchoServiceVerticle echoServiceVerticle,
            SpringControllerVerticle springControllerVerticle) {
        return args -> {
            vertx.deployVerticle(echoServiceVerticle);
            vertx.deployVerticle(springControllerVerticle);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class);
    }
}
