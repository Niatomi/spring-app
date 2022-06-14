package ru.niatomi.service;

import io.grpc.stub.StreamObserver;
import ru.niatomi.grpc.GreetingServiceGrpc;
import ru.niatomi.grpc.GreetingServiceOuterClass;

/**
 * @author niatomi
 */
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request, StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);

        GreetingServiceOuterClass.HelloResponse response =
                GreetingServiceOuterClass
                        .HelloResponse
                        .newBuilder()
                        .setGreeting("Hello, " + request.getName())
                        .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();

    }

}
