package utn.frp.p4.model.server;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import javafx.collections.ObservableList;
import utn.frp.p4.model.Whisky;

import java.util.NoSuchElementException;

public class ServerAccess {
    private static final String host = "localhost";
    private static final int port = 8080;
    
    public static Future<Void> deleteWhisky(Whisky whisky) {
        Promise<Void> promise = Promise.promise();
        WebClient client = WebClient.create(Vertx.vertx());
        client.delete(port, host, "/api/whiskies/" + whisky.getId().intValue()).send(ar -> {
            if (ar.succeeded()) {
                System.out.println("Whisky " + whisky.getId().intValue() + " - " + whisky.getName().getValue() + " exitosamente borrado");
                promise.complete();
            } else {
                promise.fail(new NoSuchElementException("Fallo de operación Delete Whisky " + ar.cause().getMessage()));
            }
        });
        return promise.future();
    }
    
    public static void getWhiskyStock(ObservableList<Whisky> whiskyData) {
        WebClient client = WebClient.create(Vertx.vertx());
        client.get(port, host, "/api/whiskies").send(ar -> {
            if (ar.succeeded()) {
                whiskyData.clear();
                HttpResponse<Buffer> response = ar.result();
                
                response.bodyAsJsonArray().forEach(whisky -> {
                    JsonObject jw = (JsonObject) whisky;
                    /*
                    NOTA: debido a un bug en vertX en la version 3.9.1 puede causar problemas a la hora de recibir los post
                    esto causa que se dupliquen llamadas de get por lo que a veces cuando se intentan agregar mas items al
                    whiskyData estos en realidad no existen.
                    ejemplo de salida esperada: [{"id":1,"name":"a","origin":"a"},{"id":2,"name":"b","origin":"b"}]
                    ejemplo de salida actual (a veces): [{"id":1,"name":"a","origin":"a"},{"id":2,"name":"b","origin":"b"}][{"id":1,"name":"a","origin":"a"},{"id":2,"name":"b","origin":"b"}]
                    este error no ocurre siempre, pero para evitar obtener excepciones no controladas es preferible lidiar con ellas usando el try/catch. Total este error de duplicacion
                    solo afectaria a lo que se ve en la tabla y no  a la base de datos.
                    Este bug parece estar en vertX web 3.5 y 3.9.1 aunque ocurre con mucha menor frecuencia y solo afectar a la version 3.9.1 .
                    */
                    try {
                        whiskyData.add(new Whisky(jw.getInteger("id"), jw.getString("name"), jw.getString("origin")));
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                });
                
                System.out.println("respuesta recibida con codigo de status " + response.statusCode());
                System.out.println(response.bodyAsJsonArray());
            } else {
                System.out.println("algo salio mal" + ar.cause().getMessage());
            }
        });
    }
    
    public static Future<Integer> insertWhisky(String name, String origin) {
        Promise<Integer> promise = Promise.promise();
        WebClient client = WebClient.create(Vertx.vertx());
        client.post(port, host, "/api/whiskies/")
                .sendJsonObject(new JsonObject()
                        .put("name", name)
                        .put("origin", origin), ar -> {
                    if (ar.succeeded()) {
                        System.out.println(ar.result().bodyAsString());
                        promise.complete(ar.result().bodyAsJsonObject().getInteger("id"));
                    } else {
                        promise.fail(
                                new NoSuchElementException("Fallo de operación Delete Whisky " +
                                        ar.cause().getMessage()));
                    }
                });
        return promise.future();
    }
    
    public static Future<Integer> updateWhisky(int id, String name, String origin) {
        Promise<Integer> promise = Promise.promise();
        WebClient client = WebClient.create(Vertx.vertx());
        client.put(port, host, "/api/whiskies/" + id)
                .sendJsonObject(new JsonObject().put("name", name).put("origin", origin), ar -> {
            if (ar.succeeded()) {
                System.out.println(ar.result().bodyAsString());
                promise.complete(id);
            } else {
                promise.fail(new NoSuchElementException("Fallo de operación Delete Whisky " + ar.cause().getMessage()));
            }
        });
        return promise.future();
    }
}
