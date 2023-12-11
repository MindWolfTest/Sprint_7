package ru.praktikum.courier;

import ru.praktikum.models.courier.Courier;
import ru.praktikum.models.courier.CourierWithOutFirstName;
import ru.praktikum.models.courier.CourierWithOutLogin;
import ru.praktikum.models.courier.CourierWithOutPassword;

import static ru.praktikum.utils.Utils.randomString;

public class CourierGenerator
{

    public static Courier randomCourier()
    {
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(16))
                .withFirstName(randomString(10));
    }

    public static CourierWithOutLogin randomCourierWithOutLogin()
    {
        return new CourierWithOutLogin()
                .withPassword(randomString(16))
                .withFirstName(randomString(10));
    }

    public static CourierWithOutPassword randomCourierWithOutPassword()
    {
        return new CourierWithOutPassword()
                .withLogin(randomString(8))
                .withFirstName(randomString(10));
    }

    public static CourierWithOutFirstName randomCourierWithOutFirstName()
    {
        return new CourierWithOutFirstName()
                .withLogin(randomString(8))
                .withPassword(randomString(16));
    }

}