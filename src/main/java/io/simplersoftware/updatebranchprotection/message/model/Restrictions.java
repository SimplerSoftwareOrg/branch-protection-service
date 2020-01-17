package io.simplersoftware.updatebranchprotection.message.model;

import java.util.Arrays;

public class Restrictions {

    private String[] users;
    private String[] teams;
    private String[] apps;

    public Restrictions(String[] users, String[] teams, String[] apps) {
        this.users = users;
        this.teams = teams;
        this.apps = apps;
    }

    public Restrictions() {
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public String[] getApps() {
        return apps;
    }

    public void setApps(String[] apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "Restrictions{" +
                "users=" + Arrays.toString(users) +
                ", teams=" + Arrays.toString(teams) +
                ", apps=" + Arrays.toString(apps) +
                '}';
    }
}
