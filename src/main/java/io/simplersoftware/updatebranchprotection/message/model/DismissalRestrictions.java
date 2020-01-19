package io.simplersoftware.updatebranchprotection.message.model;

import java.util.Arrays;

public class DismissalRestrictions {

    private String[] users;
    private String[] teams;

    public DismissalRestrictions(String[] users, String[] teams) {
        this.users = users;
        this.teams = teams;
    }

    public DismissalRestrictions() {
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

    @Override
    public String toString() {
        return "DismissalRestrictions{" + '\'' +
                "users=" + Arrays.toString(users) + '\'' +
                ", teams=" + Arrays.toString(teams) + '\'' +
                '}';
    }
}
