package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateOrderStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set request body to create order with {string}")
    public void setRequestBodyToCreateOrderWith(String json) {
        File jsonfile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateOrder(jsonfile);
    }

    @When("Send request to create order")
    public void sendRequestToCreateOrder() {
        SerenityRest.when().post(MiddlemanAPI.ORDERS);
    }
}
