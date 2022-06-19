package ru.niatomi;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ru.niatomi.grpc.GreetingServiceGrpc;
import ru.niatomi.grpc.GreetingServiceOuterClass;

import java.io.IOException;

/**
 * @author niatomi
 */
public class Application {
    public static void main(String[] args) throws InterruptedException, IOException {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc
                .newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request =
                GreetingServiceOuterClass
                        .HelloRequest
                        .newBuilder()
                        .setName("Nia")
                        .build();

        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);
        System.out.println(response);

        channel.shutdownNow();

    }
}
