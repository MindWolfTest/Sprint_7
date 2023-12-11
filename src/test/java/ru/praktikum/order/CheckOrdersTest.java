package ru.praktikum.order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static ru.praktikum.constant.MessageConst.*;
import static ru.praktikum.constant.UrlConst.*;

public class CheckOrdersTest
{
    @Before
    public void setUp()
    {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Проверка не существующего заказа")
    @Description("Проверка не существующего заказа")
    public void checkWrongOrder()
    {
        Response result = given()
                .header("Content-type", "application/json")
                .and()
                .get(TRACK_ORDER_API+"1");
        result.then().assertThat().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_SEARCH_ORDER_WITH_WRONG_TRACK));
        assertEquals("Неверный статус код",SC_NOT_FOUND, result.statusCode());
    }

    @Test
    @DisplayName("Проверка не существующего заказа с передачей пустого трека")
    @Description("Проверка не существующего заказа с передачей пустого трека")
    public void checkEmptyTackOrder()
    {
        Response result = given()
                .header("Content-type", "application/json")
                .and()
                .get(TRACK_ORDER_API);
        result.then().assertThat().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_SEARCH_ORDER_INSUFFICIENT_DATA));
        assertEquals("Неверный статус код",SC_BAD_REQUEST, result.statusCode());
    }
}
