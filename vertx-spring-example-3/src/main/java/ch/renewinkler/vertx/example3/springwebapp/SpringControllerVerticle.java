package ch.renewinkler.vertx.example3.springwebapp;

import ch.renewinkler.vertx.example3.echo.EchoServiceVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
public class SpringControllerVerticle extends AbstractVerticle {

    @RestController
    @RequestMapping(value = "/api/hello")
    public class RequestController {

        @RequestMapping(method = RequestMethod.GET, produces = "application/json")
        public void getEcho() {
            JsonObject message = new JsonObject().put("text", "Hello world!");
            vertx.eventBus().send(EchoServiceVerticle.ADDRESS, message, reply -> {
                JsonObject replyBody = (JsonObject) reply.result().body();
                System.out.println(replyBody.encodePrettily());
            });
        }

    }
}
