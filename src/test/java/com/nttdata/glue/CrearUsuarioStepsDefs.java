package com.nttdata.glue;

import com.nttdata.steps.CrearUsuario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearUsuarioStepsDefs {

    @Steps
    CrearUsuario crearUsuario;

    @When("^hago la creacion del pedido con los datos id (.*) , petId (.*) , quantity (.*) , shipDate (.*), status (.*), y complete (.*)$")
    public void hagoLaCreacionDelPedidoConLosDatosIdPetIdQuantityShipDateStatusYComplete(int id, int petId , int quantity , String shipDate , String status ,  boolean complete) {
        crearUsuario.crearpedido(id,petId,quantity,shipDate,status,complete);
    }

    @Then("el codigo de respuesta debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int codigoDeRespuesta) {
        crearUsuario.validarCodigoRespuesta(codigoDeRespuesta);
    }


    @And("^la respuesta del body tiene que tener los datos (.*),(.*),(.*),(.*),(.*),(.*)$")
    public void laRespuestaDelBodyTieneQueTenerLosDatosIdPetIdQuantityStatusComplete(int id, int petId , int quantity , String shipDate , String status ,  boolean complete) {
        crearUsuario.validarCuerpoRespuesta(id,petId,quantity,shipDate,status,complete);
    }
}
