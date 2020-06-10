package com.whisky.whiskyApp;


import com.whisky.whiskyApp.managers.WhiskyManager;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;

public class WhiskyVerticle extends AbstractVerticle {
  private PgPool client;
  private WhiskyManager whiskyManager;

  @Override
  public void start(Future<Void> startFuture) throws Exception {

    PgConnectOptions connectOptions = new PgConnectOptions()
      .setPort(5432)
      .setHost("localhost")
      .setDatabase("whisky")
      .setUser("postgres")
      .setPassword("425727");

    PoolOptions poolOptions = new PoolOptions().setMaxSize(5);

    this.client = io.vertx.pgclient.PgPool.pool(vertx, connectOptions, poolOptions);
    this.whiskyManager = new WhiskyManager(this.client);

    Router router = Router.router(vertx);
    router.route("/api/whiskies*").handler(BodyHandler.create());
    router.get("/api/whiskies").handler(this.whiskyManager::getAll);
    router.post("/api/whiskies").handler(this.whiskyManager::addOne);
    router.delete("/api/whiskies/:id").handler(this.whiskyManager::deleteOne);
    router.route("/web*").handler(StaticHandler.create("web"));

    vertx.createHttpServer().requestHandler(router).listen(8080,result ->{
      if (result.succeeded()){
        System.out.println("server is now listening");
        startFuture.complete();
      }else {
        System.out.println("failed to bind");
        startFuture.fail(result.cause());
      }
    });
  }

}
