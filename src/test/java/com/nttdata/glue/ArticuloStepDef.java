package com.nttdata.glue;

import com.nttdata.steps.ArticuloStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ArticuloStepDef {

    @Steps
    ArticuloStep articulo;

    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        articulo.definirurl(url);
    }

    @When("hago la consulta del pedido con id {int}")
    public void hagoLaConsultaDelPedidoConId(int id) {
        articulo.consultaPedido(id);
    }
    @Then("el codigo de status debe ser {int}")
    public void elCodigoDeStatusDebeSer(int status) {
        articulo.codigostatus(status);
    }
    @And("La respuesta del cuerpo debe contener la orden con id {int}")
    public void laRespuestaDelCuerpoDebeContenerLaOrdenConId(int id) {
        articulo.idrespuesta(id);
    }




}
