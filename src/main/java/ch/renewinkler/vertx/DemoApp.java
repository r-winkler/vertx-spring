package ch.renewinkler.vertx;


import ch.renewinkler.vertx.echo.EchoServiceVerticle;
import ch.renewinkler.vertx.springwebapp.SpringAppVerticle;
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
			SpringAppVerticle springAppVerticle) {
		return args -> {
			vertx.deployVerticle(echoServiceVerticle);
			vertx.deployVerticle(springAppVerticle);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class);
	}
}
