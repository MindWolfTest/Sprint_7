package ru.praktikum.models;

public class Courier
{

    private String login;
    private String password;
    private String firstName;

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public Courier withLogin(String login)
    {
        this.login = login;
        return this;
    }

    public Courier withPassword(String password)
    {
        this.password = password;
        return this;
    }

    public Courier withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString()
    {
        return "Courier{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}