package ru.praktikum.order;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.models.order.Order;
import ru.praktikum.models.order.OrderGenerator;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static ru.praktikum.constant.MessageConst.*;
import static ru.praktikum.constant.OrderConst.BLACK;
import static ru.praktikum.constant.OrderConst.GREY;
import static ru.praktikum.constant.UrlConst.BASE_URL;

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
    private int track;

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
                        {"Тест", "Тестовая", "ул. Тестовая", 1, "+7 444 555 66 66", 2, "2023-12-12", "2", new String[]{GREY}},
                        {"Тест1", "Тестовая1", "ул. Тестовая12", 2, "+7 444 333 55 55", 3, "2024-05-10", "3", new String[]{BLACK, GREY}},
                        {"Тест2", "Тестовая2", "ул. Тестовая55", 3, "+7 444 555 55 55", 4, "2024-05-10", "4", null}
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

        track = response.path(TRACK);
    }
    @After
    public void tearDown()
    {
        if(track != 0)
        {
            CancelOrder cancel = new CancelOrder();
            Response responseDelete = cancel.cancelOrder(track);
            assertEquals("Неверный статус код при отмене заказа", SC_OK, responseDelete.statusCode());
        }
    }
}
