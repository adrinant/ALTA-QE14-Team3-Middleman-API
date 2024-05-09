package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateCartStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set request with valid data product_id {string} and qty {string}")
    public void setRequestWithValidDataProduct_idAndQty(String product_id, String qty) {
        middlemanAPI.postCreateCartValidData(product_id, qty);
    }

    @Given("Set request with invalid data qty {string}")
    public void setRequestWithInvalidDataQty(String qty) {
        middlemanAPI.postCreateCartInvalidData(qty);
    }

    @When("Send request to create cart")
    public void sendRequestToCreateCart() {
        SerenityRest.when().post(MiddlemanAPI.CARTS);
    }

}
