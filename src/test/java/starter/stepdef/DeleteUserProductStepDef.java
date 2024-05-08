package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;

public class DeleteUserProductStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("Set id with {int}")
    public void setIdWith(int id) {
        middlemanAPI.deleteUserProduct(id);
    }

    @When("Send request to delete")
    public void sendRequestToDelete() {
        SerenityRest.when().delete(MiddlemanAPI.USERS_PRODUCTS_ID);
    }

    @Given("Set invalid id with {string}")
    public void setInvalidIdWith(String id) {
        middlemanAPI.deleteUserProductinvalid(id);
    }
}
