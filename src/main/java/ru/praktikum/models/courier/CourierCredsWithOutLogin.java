package ru.praktikum.models.courier;

public class CourierCredsWithOutLogin
{
    private final String password;

    public CourierCredsWithOutLogin(String password)
    {
        this.password = password;
    }

    public static CourierCredsWithOutLogin fromCourierWithOutLogin(Courier courier)
    {
        return new CourierCredsWithOutLogin(courier.getPassword());
    }

    @Override
    public String toString()
    {
        return "CourierCredsWithOutLogin{" +
                ", password='" + password + '\'' +
                '}';
    }
}
