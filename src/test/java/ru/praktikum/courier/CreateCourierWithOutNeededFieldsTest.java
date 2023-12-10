package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.praktikum.courier.CourierClientCreateAndAuthorization;
import ru.praktikum.models.Courier;
import ru.praktikum.models.CourierWithOutFirstName;
import ru.praktikum.models.CourierWithOutLogin;
import ru.praktikum.models.CourierWithOutPassword;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static ru.praktikum.constant.MessageConst.*;
import static ru.praktikum.courier.CourierGenerator.*;
import static ru.praktikum.models.CourierCreds.fromCourier;

public class CreateCourierWithOutNeededFieldsTest extends BeforeAndAfter
{
    @Test
    @DisplayName("Создание курьера без логина")
    @Description("Создание курьера без логина со случайными данными")
    public void createCourierWithoutLogin()
    {
        CourierWithOutLogin courierWithOutLogin = randomCourierWithOutLogin();

        //System.out.println("без логина: " + courierWithOutLogin);

        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response response = courierClientCreateAndAuthorization.createWithOutLogin(courierWithOutLogin);

        response.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_CREATE_INSUFFICIENT_DATA));
    }

    @Test
    @DisplayName("Создание курьера без пароля")
    @Description("Создание курьера без пароля со случайными данными")
    public void createCourierWithoutPassword()
    {
        CourierWithOutPassword courierWithOutPassword = randomCourierWithOutPassword();

        //System.out.println("без пароля: " + courierWithOutPassword);

        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response response = courierClientCreateAndAuthorization.createWithOutPassword(courierWithOutPassword);

        response.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_CREATE_INSUFFICIENT_DATA));
    }

    @Test
    @DisplayName("Создание 2ух одинаковых курьеров")
    @Description("Создание 2ух одинаковых курьеров со случайными данными")
    public void createCourier()
    {
        Courier courier = randomCourier();
        CourierClientCreateAndAuthorization courierFirstClientCreate = new CourierClientCreateAndAuthorization();
        CourierClientCreateAndAuthorization courierSecondClientCreate = new CourierClientCreateAndAuthorization();

        Response responseForFirstCourier = courierFirstClientCreate.create(courier);

        responseForFirstCourier.then().assertThat().statusCode(SC_CREATED)
                .and().body(OK, equalTo(true));

        Response responseForSecondCourier = courierSecondClientCreate.create(courier);

        responseForSecondCourier.then().assertThat().statusCode(SC_CONFLICT)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_CREATE_DOUBLE_USER_DATA));
    }

    @Test
    @DisplayName("Создание курьера без имени")
    @Description("Создание курьера без имени со случайными данными")
    public void createCourierWithOutFirstName()
    {
        CourierWithOutFirstName courierWithOutFirstName = randomCourierWithOutFirstName();
        CourierClientCreateAndAuthorization courierClient = new CourierClientCreateAndAuthorization();

        Response responseForFirstCourier = courierClient.createWithOutFirstName(courierWithOutFirstName);

        responseForFirstCourier.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_CREATE_INSUFFICIENT_DATA));
    }
}
