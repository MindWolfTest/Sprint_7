package ru.praktikum.order;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static ru.praktikum.constant.UrlConst.*;

public class CancelOrder
{
    @Step("Отмена заказа")
    public Response cancelOrder(int track)
    {
        return given()
                .queryParam("track", track)
                .put(CANCEL_ORDER_API);
    }
}
