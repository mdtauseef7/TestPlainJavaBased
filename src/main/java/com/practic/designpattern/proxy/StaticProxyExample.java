package com.practic.designpattern.proxy;

// Define a service interface
interface Service {
    void execute();
}

// Implement the real service class of the service interface
class RealService implements Service {
    @Override
    public void execute() {
        System.out.println("RealService is executing...");
    }
}

// Proxy service class, holds a reference to the real service object
class ServiceProxy implements Service {
    private Service realService;

    public ServiceProxy() {
        this.realService = new RealService();
    }

    @Override
    public void execute() {
        System.out.println("Additional operations before calling the real service, such as logging or permission checking");
        realService.execute();
        System.out.println("Additional operations after calling the real service, such as performance statistics");
    }
}


// Test static proxy
public class StaticProxyExample {
    public static void main(String[] args) {
        Service service = new ServiceProxy();
        // Call the execute method through the proxy
        service.execute();
    }
}