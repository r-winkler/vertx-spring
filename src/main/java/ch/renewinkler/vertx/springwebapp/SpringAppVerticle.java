package ch.renewinkler.vertx.springwebapp;

import ch.renewinkler.vertx.echo.EchoServiceVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import io.vertx.core.json.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class SpringAppVerticle extends AbstractVerticle {


	private Vertx myVertx;

	@Override
	public void start() {
		SpringApplication.run(SpringAppVerticle.class);
		System.out.println("SpringAppVerticle started!");
		this.myVertx = vertx;
	}


	@RestController
	@RequestMapping(value = "/api/hello")
	public class RequestController {

		@RequestMapping(method = RequestMethod.GET, produces = "application/json")
		public void getEcho() {
			JsonObject message = new JsonObject()
					.put("text", "Hello world!");
			myVertx.eventBus().send(EchoServiceVerticle.ADDRESS, message, reply -> {
				JsonObject replyBody = (JsonObject) reply.result().body();
				System.out.println(replyBody.encodePrettily());
			});
		}

	}
}
