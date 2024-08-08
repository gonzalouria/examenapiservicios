package com.nttdata.steps;

import com.nttdata.model.Articulo;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ArticuloStep {

    private static String URL = null;
    Response response;

    public void definirurl(String url){
        URL = url;
    };

    public void consultaPedido(int id) {

        response = SerenityRest.given()
                        .contentType("application/json")
                        .log()
                        .all()
                        .get(URL+"store/order/" + id)
                        .then()
                        .log()
                        .all()
                        .extract().response();
        ;
    }

    public void codigostatus(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
    }
    public void idrespuesta(int id) {
        SerenityRest.restAssuredThat(response -> response.body("'id'", equalTo(id)));

    }









}
