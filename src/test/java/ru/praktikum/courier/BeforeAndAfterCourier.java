package ru.praktikum.courier;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static ru.praktikum.constant.UrlConst.BASE_URL;

public class BeforeAndAfterCourier
{
    protected int id;
    @Before
    public void setUp()
    {
        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void tearDown()
    {
        if(id != 0)
        {
            DeleteCourier courierClientDelete = new DeleteCourier();
            Response responseDelete = courierClientDelete.deleteCourier(id);
            assertEquals("Неверный статус код при удалении курьера", SC_OK, responseDelete.statusCode());
        }
    }
}
