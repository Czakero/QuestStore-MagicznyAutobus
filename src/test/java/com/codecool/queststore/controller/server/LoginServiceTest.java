package com.codecool.queststore.controller.server;

import com.codecool.queststore.controller.server.service.LoginService;
import com.codecool.queststore.model.Login;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.*;

class LoginServiceTest {
    String name = "Seba";
    String password = "dupa";

    @Test
    void testLoginServiceConstructor(){
        Login login = mock(Login.class);
        when(login.SignIn()).thenReturn(null);
        LoginService loginService = new LoginService(name, password);
        assertEquals(null, loginService.getSession());
    }



}