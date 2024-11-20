package org.BerlTech;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) throws IOException {
        int serverPort = 8080;
        var server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        server.createContext("/api",
                ( exchange -> {
                    String response = "hello world!!!";
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    var output = exchange.getResponseBody();
                    output.write(response.getBytes());
                    output.flush();
                    exchange.close();
                }));

        server.setExecutor(null); // creates a default executor
        server.start();
    }
}