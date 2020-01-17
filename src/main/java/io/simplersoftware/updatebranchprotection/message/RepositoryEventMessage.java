package io.simplersoftware.updatebranchprotection.message;

import io.simplersoftware.updatebranchprotection.message.model.Repository;


public class RepositoryEventMessage {
    private String action;
    private Repository repository;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }


    @Override
    public String toString() {
        return "RepositoryEventMessage{" +
                "action='" + action + '\'' +
                ", repository=" + repository +
                '}';
    }
}
