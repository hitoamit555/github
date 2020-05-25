package com.hackerrank.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Actor {
    @Id
    private Long id;
    private String login;
    private String avatar_url;

    @Transient
    private int totalEvents = 0;

    public Actor() {
    }

    public Actor(Long id, String login, String avatar) {
        this.setId(id);
        this.setLogin(login);
        this.setAvatar_url(avatar);
    }

    public Actor(Long id, String login, String avatar, int totalEvents) {
        this.setId(id);
        this.setLogin(login);
        this.setAvatar_url(avatar);
        this.setTotalEvents(totalEvents);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar) {
        this.avatar_url = avatar;
    }

    public void setTotalEvents(int totalEvents) {
        this.totalEvents = totalEvents;
    }
}
