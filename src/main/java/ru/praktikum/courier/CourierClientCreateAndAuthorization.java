package ru.praktikum.courier;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.models.courier.*;

import static io.restassured.RestAssured.given;
import static ru.praktikum.constant.UrlConst.COURIER_API;
import static ru.praktikum.constant.UrlConst.COURIER_LOGIN_API;

public class CourierClientCreateAndAuthorization
{


    @Step("Создание курьера {courier}")
    public Response create(Courier courier)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(COURIER_API);
    }

    @Step("Создание курьера без логина {courierWithOutLogin}")
    public Response createWithOutLogin(CourierWithOutLogin courierWithOutLogin)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierWithOutLogin)
                .when()
                .post(COURIER_API);
    }

    @Step("Создание курьера без пароля {courierWithOutPassword}")
    public Response createWithOutPassword(CourierWithOutPassword courierWithOutPassword)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierWithOutPassword)
                .when()
                .post(COURIER_API);
    }

    @Step("Создание курьера без имени {courierWithOutFirstName}")
    public Response createWithOutFirstName(CourierWithOutFirstName courierWithOutFirstName)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierWithOutFirstName)
                .when()
                .post(COURIER_API);
    }

    @Step("Авторизация курьером с кредами {courierCreds}")
    public Response login(CourierCreds courierCreds)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierCreds)
                .when()
                .post(COURIER_LOGIN_API);
    }

    @Step("Авторизация курьером с кредами без логина {courierCredsWithOutLogin}")
    public Response loginWithOutUserLogin(CourierCredsWithOutLogin courierCredsWithOutLogin)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierCredsWithOutLogin)
                .when()
                .post(COURIER_LOGIN_API);
    }

    @Step("Авторизация курьером с кредами без логина {courierCredsWithOutLogin}")
    public Response loginWithOutUserPassword(CourierCredsWithOutPassword courierCredsWithOutPassword)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierCredsWithOutPassword)
                .when()
                .post(COURIER_LOGIN_API);
    }
}