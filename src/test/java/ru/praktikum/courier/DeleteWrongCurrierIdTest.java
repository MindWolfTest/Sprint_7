package ru.praktikum.courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.courier.CourierClientCreateAndAuthorization;
import ru.praktikum.courier.DeleteCourier;
import ru.praktikum.models.courier.Courier;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static ru.praktikum.constant.MessageConst.*;
import static ru.praktikum.constant.UrlConst.BASE_URL;
import static ru.praktikum.courier.CourierGenerator.randomCourier;
import static ru.praktikum.models.courier.CourierCreds.fromCourier;

public class DeleteWrongCurrierIdTest
{
    private int id;
    @Before
    public void setUp()
    {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Удаление курьера")
    @Description("Удаление не существующего курьера")
    public void deleteWrongCourierId()
    {
        DeleteCourier courierClientDelete = new DeleteCourier();
        Response responseDelete = courierClientDelete.deleteCourier(12);
        //assertEquals("Неверный статус код при удалении курьера", SC_NOT_FOUND, responseDelete.statusCode());
        responseDelete.then().assertThat().statusCode(SC_NOT_FOUND)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_NOT_FOUND));
    }

    @Test
    @DisplayName("Удаление курьера")
    @Description("Удаление курьера без id")
    public void deleteNullCourierId()
    {
        DeleteCourier courierClientDelete = new DeleteCourier();
        Response responseDelete = courierClientDelete.deleteCourier(null);
        //assertEquals("Неверный статус код при удалении курьера без указания id", SC_BAD_REQUEST, responseDelete.statusCode());
        responseDelete.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_DELETE_INSUFFICIENT_DATA));
    }

    @Test
    @DisplayName("Удаление курьера")
    @Description("Удаление созданного курьера")
    public void deleteCurrentCourier()
    {

        Courier courier = randomCourier();
        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response response = courierClientCreateAndAuthorization.create(courier);

        response.then().assertThat().statusCode(SC_CREATED)
                .and().body(OK, equalTo(true));
        Response loginResponse = courierClientCreateAndAuthorization.login(fromCourier(courier));
        id = loginResponse.path("id");

        DeleteCourier courierClientDelete = new DeleteCourier();
        Response responseDelete = courierClientDelete.deleteCourier(id);
        responseDelete.then().assertThat().statusCode(SC_OK)
                .and().body(OK, equalTo(true));
    }

}
