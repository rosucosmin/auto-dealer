package com.siemens.ct.bam.users;

public class User {

    private String name;
    private String surname;
    private Long cnp;

    User(Long cnp, String surname, String name)
    {
        this.cnp = cnp;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }


    @Override
    public String toString() {
        return "User{ " + "Name: " + surname + " " + name + ", CNP: " + cnp + "}";
    }
}
