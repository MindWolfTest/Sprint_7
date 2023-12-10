package ru.praktikum.models.order;
import ru.praktikum.models.order.Order;


public class OrderGenerator
{
    public Order orderGenerator(String firstName, String lastName, String address, int metroStation, String phone,
                                        int rentTime, String deliveryDate, String comment, String[] color)
    {
        return new Order()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .setRentTime(rentTime)
                .setDeliveryDate(deliveryDate)
                .setComment(comment)
                .setColor(color);
    }
}
