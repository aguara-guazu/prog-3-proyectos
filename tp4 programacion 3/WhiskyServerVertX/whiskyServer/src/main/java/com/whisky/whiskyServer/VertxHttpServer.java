package com.whisky.whiskyServer;


import io.vertx.core.Vertx;

public class VertxHttpServer {
  public static void main(String[] args){
    final Vertx vertx = Vertx.factory.vertx();
    vertx.deployVerticle(new WhiskyVerticle());
  }
}
