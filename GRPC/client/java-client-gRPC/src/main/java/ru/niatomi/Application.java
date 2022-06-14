package ru.niatomi;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ru.niatomi.service.GreetingServiceImpl;

import java.io.IOException;

/**
 * @author niatomi
 */
public class Application {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();

        System.out.println("Server started");

        server.awaitTermination();
    }
}
