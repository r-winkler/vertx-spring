package ch.renewinkler.vertx.example1.echo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceVerticle extends AbstractVerticle {

    public static final String ADDRESS = "echo-service";

    @Override
    public void start() {
        vertx.eventBus().consumer(EchoServiceVerticle.ADDRESS, message -> {
            System.out.println("message received");
            JsonObject messageBody = (JsonObject) message.body();
            messageBody.put("passedThrough", "echo-service");
            message.reply(messageBody);
        });
    }

}
