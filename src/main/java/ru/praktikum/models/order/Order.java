package ru.praktikum.models.order;

public class Order
{
    private String firstName;
    private String lastName;
    private String address;
    private int metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    public String getFirstName()
    {
        return firstName;
    }

    public Order setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Order setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public String getAddress()
    {
        return address;
    }

    public Order setAddress(String address)
    {
        this.address = address;
        return this;
    }

    public int getMetroStation()
    {
        return metroStation;
    }

    public Order setMetroStation(int metroStation)
    {
        this.metroStation = metroStation;
        return this;
    }

    public String getPhone()
    {
        return phone;
    }

    public Order setPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public int getRentTime()
    {
        return rentTime;
    }

    public Order setRentTime(int rentTime)
    {
        this.rentTime = rentTime;
        return this;
    }

    public String getDeliveryDate()
    {
        return deliveryDate;
    }

    public Order setDeliveryDate(String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public String getComment()
    {
        return comment;
    }

    public Order setComment(String comment)
    {
        this.comment = comment;
        return this;
    }

    public String[] getColor()
    {
        return color;
    }

    public Order setColor(String[] color)
    {
        this.color = color;
        return this;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", metroStation='" + metroStation + '\'' +
                ", phone='" + phone + '\'' +
                ", rentTime='" + rentTime + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", comment='" + comment + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
