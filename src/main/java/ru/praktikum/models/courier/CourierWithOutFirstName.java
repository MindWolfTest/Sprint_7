package ru.praktikum.models.courier;

public class CourierWithOutFirstName
{
    private String login;
    private String password;

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public CourierWithOutFirstName withLogin(String login)
    {
        this.login = login;
        return this;
    }

    public CourierWithOutFirstName withPassword(String password)
    {
        this.password = password;
        return this;
    }

    @Override
    public String toString()
    {
        return "CourierWithOutFirstName{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
