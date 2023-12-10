package ru.praktikum.models;

public class CourierWithOutLogin
{
    private String password;
    private String firstName;


    public String getPassword()
    {
        return password;
    }



    public CourierWithOutLogin withPassword(String password)
    {
        this.password = password;
        return this;
    }

    public CourierWithOutLogin withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString()
    {
        return "CourierWithOutLogin{" +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
