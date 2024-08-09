package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import io.restassured.response.Response;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearUsuario {

    private static String CREATE_USER = "https://petstore.swagger.io/v2/store/order";
    private Response response;



    public void crearpedido(int id, int petId, int quantity, String shipdate, String status, boolean complete) {
        response = given().baseUri(CREATE_USER)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipdate + "\",\n" +
                        "  \"status\": \"" + status+ "\",\n" +
                        "  \"complete\": " + complete + " \n" +
                        "}")
                .log().all()
                .when()
                .post(CREATE_USER)
                .then()
                .extract()
                .response()
        ;
    }


    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }


    public void validarCuerpoRespuesta(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        restAssuredThat(response -> response.body("'id'", equalTo(id)));
        restAssuredThat(response -> response.body("'petId'", equalTo(petId)));
        restAssuredThat(response -> response.body("'quantity'", equalTo(quantity)));
        restAssuredThat(response -> response.body("'shipDate'", equalTo(shipDate)));
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        restAssuredThat(response -> response.body("'complete'", equalTo(complete)));

    }
}
