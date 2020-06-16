package com.whisky.whiskyServer.managers;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.Tuple;

import com.whisky.whiskyServer.data.Whisky;

import java.util.ArrayList;
import java.util.List;

public class WhiskyManager {

  private PgPool client;

  public WhiskyManager(PgPool client) {
    this.client = client;
  }

  public void getAll(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    this.client
      .query("SELECT * FROM public.whisky order by name")
      .execute(ar -> {
        if (ar.succeeded()) {
          RowSet<Row> rows = ar.result();
          List<Whisky> products = new ArrayList<>();
          rows.forEach(row -> {
            String name = row.getString("name");
            String origin = row.getString("origin");
            Integer id = row.getInteger("id");
            Whisky whisky = new Whisky(name,origin);
            whisky.setId(id);
            products.add(whisky);
          });

          response.putHeader("content-type", "application/json; charset=utf-8")
            .setStatusCode(200)
            .end(Json.encodePrettily(products));
        } else {
          System.out.println("Failure: " + ar.cause().getMessage());
          response.putHeader("content-type", "application/json; charset=utf-8")
            .end(Json.encodePrettily(ar.cause().getMessage()));
        }
      });
  }

  public void addOne(RoutingContext routingContext) {
    Whisky whisky = Json.decodeValue(routingContext.getBodyAsString(),Whisky.class);
    HttpServerResponse response = routingContext.response();
    this.client
      .preparedQuery("INSERT INTO public.whisky (id,name,origin) VALUES (DEFAULT,$1, $2) RETURNING id")
      .execute(Tuple.of(whisky.getName(), whisky.getOrigin()),  ar -> {
        if (ar.succeeded()) {
          //RowSet<Row> rows = ar.result();
          response.putHeader("content-type", "application/json; charset=utf-8")
            .setStatusCode(201)
            .end(Json.encodePrettily(whisky));

        } else {
          System.out.println("Failure: " + ar.cause().getMessage());
          response.putHeader("content-type", "application/json; charset=utf-8")
            .end(Json.encodePrettily(ar.cause().getMessage()));
        }
      });
  }

  public void deleteOne(RoutingContext routingContext) {
    String id = routingContext.request().getParam("id");
    if (id == null) {
      routingContext.response().setStatusCode(400).end();
    } else {
      Integer idAsInteger = Integer.valueOf(id);
      HttpServerResponse response = routingContext.response();

      this.client
        .preparedQuery("DELETE FROM public.whisky WHERE id = $1")
        .execute(Tuple.of(idAsInteger),  ar -> {
          if (ar.succeeded()) {
            response.putHeader("content-type", "application/json; charset=utf-8")
              .setStatusCode(204)
              .end();
          } else {
            System.out.println("Failure: " + ar.cause().getMessage());
            response.putHeader("content-type", "application/json; charset=utf-8")
              .end(Json.encodePrettily(ar.cause().getMessage()));
          }
        });
    }
  }

}
