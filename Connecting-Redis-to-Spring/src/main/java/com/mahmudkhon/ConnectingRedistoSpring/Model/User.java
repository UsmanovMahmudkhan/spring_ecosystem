package com.mahmudkhon.ConnectingRedistoSpring.Model;

public class User {
    private Integer id;
    private String name;
    private String field;


    public User(Integer id, String name, String field) {
        this.id = id;
        this.name = name;
        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", field='" + getField() + '\'' +
                '}';
    }
}
