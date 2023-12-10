package ru.praktikum.order;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.models.order.Order;
import ru.praktikum.models.order.OrderGenerator;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static ru.praktikum.constant.MessageConst.*;
import static ru.praktikum.constant.OrderConst.BLACK;
import static ru.praktikum.constant.OrderConst.GREY;
import static ru.praktikum.constant.UrlConst.BASE_URL;
import static ru.praktikum.constant.UrlConst.ORDER_API;
import static ru.praktikum.models.courier.CourierCreds.fromCourier;

@RunWith(Parameterized.class)
public class CreateOrderTest
{
    private final String firstName;
    private final String lastName;
    private final String address;
    private final int metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String[] color;

    public CreateOrderTest(String firstName, String lastName, String address, int metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Parameterized.Parameters()
    public static Object[][] getParameters()
    {
        return new Object[][]
                {
                        {"Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "1", new String[]{BLACK}},
                        //{}
                };
    }

    @Before
    public void setUp()
    {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Создание заказа")
    @Description("Создание заказа")
    public void createOrder()
    {
        OrderGenerator createNewOrder = new OrderGenerator();
        Order order = createNewOrder.orderGenerator(firstName, lastName, address, metroStation, phone, rentTime,
                                                    deliveryDate, comment, color);
        OrderCreate orderCreate = new OrderCreate();

        Response response = orderCreate.createNewOrder(order);
        response.then().assertThat().statusCode(SC_CREATED)
                .and().body(TRACK, notNullValue());
    }
}
