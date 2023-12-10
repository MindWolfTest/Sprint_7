package ru.praktikum.courier;


import ru.praktikum.models.Courier;

import static ru.praktikum.utils.Utils.randomString;

public class CourierGenerator
{

    public static Courier randomCourier() {
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(16))
                .withFirstName(randomString(10));
    }
}