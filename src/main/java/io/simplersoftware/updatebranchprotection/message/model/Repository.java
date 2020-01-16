package io.simplersoftware.updatebranchprotection.message.model;

public class Repository {

    private Owner owner;
    private String name;
    private long id;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "owner=" + owner +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
