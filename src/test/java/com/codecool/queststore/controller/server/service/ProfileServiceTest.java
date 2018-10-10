package com.codecool.queststore.controller.server.service;

import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.jws.soap.SOAPBinding;
import java.net.HttpCookie;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProfileServiceTest {

    @Test
    void testIfHandlePostCrashesIfGetEmptyInput() {
        ProfileService profileService = new ProfileService(null, "");
        assertThrows(NullPointerException.class, () ->
                profileService.handlePost(Mockito.spy(Map.class)));
    }

    @Test
    void testIfHandlePostHandlesUnexpectedInput() {
        ProfileService profileService = new ProfileService(null, "");
        Map<String, String> map = new HashMap<>();
        map.put("submit", "unexpected input");
        Assertions.assertDoesNotThrow(() -> profileService.handlePost(map));
    }

}