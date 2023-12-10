package ru.praktikum.courier;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.models.Courier;
import ru.praktikum.models.CourierCreds;

import static io.restassured.RestAssured.given;
import static ru.praktikum.constant.UrlConst.COURIER_API;
import static ru.praktikum.constant.UrlConst.COURIER_LOGIN_API;

public class CorrectCourierClientCreateAndAuthorization
{


    @Step("Создание курьера {courier}")
    public Response create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(COURIER_API);
    }

    @Step("Авторизация курьером с кредами {courierCreds}")
    public Response login(CourierCreds courierCreds) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierCreds)
                .when()
                .post(COURIER_LOGIN_API);
    }
}