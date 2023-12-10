package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.praktikum.courier.CourierClientCreateAndAuthorization;
import ru.praktikum.models.Courier;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static ru.praktikum.constant.MessageConst.*;
import static ru.praktikum.courier.CourierGenerator.randomCourier;
import static ru.praktikum.models.CourierCreds.fromCourier;
import static ru.praktikum.models.CourierCredsWithOutLogin.fromCourierWithOutLogin;
import static ru.praktikum.models.CourierCredsWithOutPassword.fromCourierWithOutPassword;

public class CourierLoginTest extends BeforeAndAfter
{

    @Test
    @DisplayName("Авторизация курьера")
    @Description("Авторизация курьера с корректно заполненными данными")
    public void loginCourier()
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
    @Test
    @DisplayName("Авторизация курьера без логина")
    @Description("Авторизация курьера без логина")
    public void loginCourierWithOutLogin()
    {
        Courier courier = randomCourier();
        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response response = courierClientCreateAndAuthorization.create(courier);

        response.then().assertThat().statusCode(SC_CREATED)
                .and().body(OK, equalTo(true));

        Response loginResponse = courierClientCreateAndAuthorization.loginWithOutUserLogin(fromCourierWithOutLogin(courier));

        loginResponse.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_LOGIN_INSUFFICIENT_DATA));
    }

    @Test
    @DisplayName("Авторизация курьера без пароля")
    @Description("Авторизация курьера без пароля")
    public void loginCourierWithOutPassword()
    {
        Courier courier = randomCourier();
        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response response = courierClientCreateAndAuthorization.create(courier);

        response.then().assertThat().statusCode(SC_CREATED)
                .and().body(OK, equalTo(true));

        Response loginResponse = courierClientCreateAndAuthorization.loginWithOutUserPassword(fromCourierWithOutPassword(courier));

        loginResponse.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_LOGIN_INSUFFICIENT_DATA));
    }

    @Test
    @DisplayName("Авторизация не созданным курьером")
    @Description("Авторизация не созданным курьером")
    public void loginUnCreatedCourier()
    {
        Courier courier = randomCourier();
        CourierClientCreateAndAuthorization courierClientCreateAndAuthorization = new CourierClientCreateAndAuthorization();

        Response loginResponse = courierClientCreateAndAuthorization.login(fromCourier(courier));


        loginResponse.then().assertThat().statusCode(SC_NOT_FOUND)
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_FOR_LOGIN_ACCOUNT_NOT_FOUND));
    }


}
