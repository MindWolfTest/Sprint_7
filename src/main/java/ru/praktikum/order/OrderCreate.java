package ru.praktikum.order;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.models.order.Order;

import static io.restassured.RestAssured.given;
import static ru.praktikum.constant.UrlConst.ORDER_API;

public class OrderCreate
{
    @Step("Создание заказа {order}")
    public Response createNewOrder(Order order)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(ORDER_API);
    }
}
