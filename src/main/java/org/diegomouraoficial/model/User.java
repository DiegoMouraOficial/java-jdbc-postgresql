package org.diegomouraoficial.model;
public class User {
    private int id;
    private String name;
    private String email;

    //#region ... Constructor
    public User() {}
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    //#endregion

    //#region ... Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //#endregion

    //#region ... to String
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    //#endregion
}
