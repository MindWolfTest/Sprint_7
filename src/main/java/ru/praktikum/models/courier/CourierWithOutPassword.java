package ru.praktikum.models;

public class CourierWithOutPassword
{
    private String login;
    private String firstName;

    public String getLogin()
    {
        return login;
    }

    public CourierWithOutPassword withLogin(String login)
    {
        this.login = login;
        return this;
    }


    public CourierWithOutPassword withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString()
    {
        return "Courier{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
