package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class CartsStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set path for carts")
    public void setPathForCarts() {
        middlemanAPI.getCarts();
    }

    @When("Send request to get carts")
    public void sendRequestToGetCarts() {
        SerenityRest.when().get(MiddlemanAPI.CARTS);
    }

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

    @Given("Set parameter to update cart valid id {} and request data qty {string}")
    public void setParameterToUpdateCartValidIdAndRequestDataQty(int id, String qty) {
        middlemanAPI.putUpdateCartValidId(id, qty);
    }

    @Given("Set parameter to update cart invalid id {string} and request data qty {string}")
    public void setParameterToUpdateCartInvalidIdAndRequestDataQty(String id, String qty) {
        middlemanAPI.putUpdateCartInvalidId(id, qty);
    }

    @Given("Set parameter to update cart valid id {} and request invalid data qty {string}")
    public void setParameterToUpdateCartValidIdAndRequestInvalidDataQty(int id, String qty) {
        middlemanAPI.putUpdateCartValidId(id, qty);
    }

    @When("Send request to update cart")
    public void sendRequestToUpdateCart() {
        SerenityRest.when().put(MiddlemanAPI.CARTS_ID);
    }

    @Given("Set carts id with {int}")
    public void setCartsIdWith(int id) {
        middlemanAPI.deleteCartValidId(id);
    }

    @When("Send request to delete cart")
    public void sendRequestToDeleteCart() {
        SerenityRest.when().delete(MiddlemanAPI.CARTS_ID);
    }

    @Given("Set carts invalid id with {string}")
    public void setCartsInvalidIdWith(String id) {
        middlemanAPI.deleteCartInvalidId(id);
    }

}
