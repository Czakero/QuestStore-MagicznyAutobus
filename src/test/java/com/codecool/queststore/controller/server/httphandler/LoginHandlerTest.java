package com.codecool.queststore.controller.server.httphandler;

import com.codecool.queststore.controller.server.httphandler.LoginHandler;
import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginHandlerTest {

    static LoginHandler loginHandler;

    @BeforeAll
    static void setUp() {
        loginHandler = spy(new LoginHandler());
    }


    @Test
    void testIfHandlePostMethodGetsCalled() throws Exception {
        HttpExchange mockHttpExchange = mock(HttpExchange.class);
        when(mockHttpExchange.getRequestMethod()).thenReturn("POST");

        doNothing().when(loginHandler).handlePost(mockHttpExchange);
        loginHandler.handle(mockHttpExchange);
        verify(loginHandler).handlePost(mockHttpExchange);
    }
}