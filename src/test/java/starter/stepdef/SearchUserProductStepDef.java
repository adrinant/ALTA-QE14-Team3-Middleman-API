package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class SearchUserProductStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("Set parameter to {string}")
    public void setParameterTo(String Parameter) {
        middlemanAPI.getSearchUserProduct(Parameter);
    }

    @When("Send request to search")
    public void sendRequestToSearch() {
        SerenityRest.when().get(MiddlemanAPI.USERS_PRODUCTS_ID);
    }
}
