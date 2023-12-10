package ru.praktikum.models;

public class CourierCredsWithOutPassword
{
    private final String login;

    public CourierCredsWithOutPassword(String login)
    {
        this.login = login;
    }

    public static CourierCredsWithOutPassword fromCourierWithOutPassword(Courier courier)
    {
        return new CourierCredsWithOutPassword(courier.getLogin());
    }

    @Override
    public String toString()
    {
        return "CourierCreds{" +
                "login='" + login + '\'' +
                '}';
    }
}
