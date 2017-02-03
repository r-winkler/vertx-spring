package ch.renewinkler.vertx;


import ch.renewinkler.vertx.echo.EchoServiceVerticle;
import ch.renewinkler.vertx.springwebapp.SpringAppVerticle;
import io.vertx.core.Vertx;

public class DemoApp {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new EchoServiceVerticle());
        vertx.deployVerticle(new SpringAppVerticle());

    }
}
