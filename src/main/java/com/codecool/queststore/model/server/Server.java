package com.codecool.queststore.model.server;

import com.codecool.queststore.controller.server.httphandler.LoginHandler;
import com.codecool.queststore.controller.server.httphandler.TestHandler;
import com.codecool.queststore.model.server.session.SessionPool;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private HttpServer server;

    public void run() throws IOException {
        server = HttpServer.create(new InetSocketAddress(8000), 0);
        setContext(server);
        server.setExecutor(null);
        new SessionPool();
        server.start();
    }

    // Overload to run server on desired port
    public void run(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        setContext(server);
        server.setExecutor(null);
        server.start();
    }

    private void setContext(HttpServer server){
        server.createContext("/", new LoginHandler());
        server.createContext("/profile", new TestHandler());

    }

    public void stop(){
        server.stop(0);
    }
}