package com.codecool.queststore;

import com.codecool.queststore.model.server.Server;
import com.codecool.queststore.model.server.session.Session;
import com.codecool.queststore.model.server.session.SessionPool;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.net.SocketException;

import static junit.framework.TestCase.assertEquals;


public class AppTest {

    @Test
    public void ifUserHasWalletTRUE() {
        User userTest = new User("janek", "wiśniewski", "@.pl", "asd", 1, Role.MENTOR);
        assertEquals(null, userTest.getWallet());
    }

    @Rule
    public ExpectedException exc = ExpectedException.none();

    @Test
    public void canRunServerOnPort80FALSE() throws IOException {
        exc.expect(SocketException.class);
        exc.expectMessage("Permission denied");
        System.out.println("Cannot run on port 80!");
        Server srv = new Server();

        srv.run(80);

    }

    @Test
    public void ifSessionRemovedTRUE() {
        SessionPool sp = new SessionPool();
        Session s = sp.getNewSession(1);
        sp.terminate(s);
        assertEquals(false, sp.sessions.contains(s));

    }
}
