package ru.praktikum.courier;


import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static ru.praktikum.constant.UrlConst.COURIER_API;

public class DeleteCourier
{
    @Step("Удаление курьера")
    public Response deleteCourier(Integer id)
    {
        return given()
                .delete(COURIER_API + String.format("/%d", id));
    }
}
