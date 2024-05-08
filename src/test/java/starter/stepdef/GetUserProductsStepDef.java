package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class GetUserProductsStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set path and token")
    public void setPathAndToken() {
        middlemanAPI.getUserProducts();
    }

    @When("Send request to get user products")
    public void sendRequestToGetUserProducts() {
        SerenityRest.when().get(MiddlemanAPI.USERS_PRODUCTS);
    }
}
