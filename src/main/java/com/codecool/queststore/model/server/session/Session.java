package com.codecool.queststore.model.server.session;

import java.io.Serializable;
import java.net.HttpCookie;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Session implements Serializable {

    private final UUID uuid;
    private final int USER_ID;
    private final LocalDateTime expirationDate = LocalDateTime.now().plusHours(4);

    Session (int userId) {
        this.uuid = UUID.randomUUID();
        this.USER_ID = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return Objects.equals(uuid, session.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid);
    }

    UUID getUuid() {
        return uuid;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public HttpCookie getCookie() {

        return new HttpCookie("ID-Session",this.uuid.toString());

    }

    LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}