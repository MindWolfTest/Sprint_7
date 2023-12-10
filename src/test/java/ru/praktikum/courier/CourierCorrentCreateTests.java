package ru.praktikum.courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.praktikum.models.courier.Courier;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static ru.praktikum.constant.MessageConst.ID;
import static ru.praktikum.constant.MessageConst.OK;
import static ru.praktikum.courier.CourierGenerator.randomCourier;
import static ru.praktikum.models.courier.CourierCreds.fromCourier;

public class CourierCorrentCreateTests extends BeforeAndAfterCourier
{
    @Test
    @DisplayName("Создание курьера")
    @Description("Создание курьера со случайными данными")
    public void createCourier()
    {
        Courier courier = randomCourier();
        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response response = courierClientCreateAndAuthorization.create(courier);

        response.then().assertThat().statusCode(SC_CREATED)
                .and().body(OK, equalTo(true));

        Response loginResponse = courierClientCreateAndAuthorization.login(fromCourier(courier));
        id = loginResponse.path("id");

        loginResponse.then().assertThat().statusCode(SC_OK)
                .and().body(ID, notNullValue());
    }
}