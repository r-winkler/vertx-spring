package ch.renewinkler.vertx.example3;

import ch.renewinkler.vertx.example3.echo.EchoServiceVerticle;
import ch.renewinkler.vertx.example3.springwebapp.SpringControllerVerticle;
import io.vertx.core.Vertx;
import org.springframework.boot.SpringApplication;

public class DemoApp {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new EchoServiceVerticle());
        vertx.deployVerticle(SpringApplication.run(SpringControllerVerticle.class).getBean(SpringControllerVerticle.class));
    }
}
