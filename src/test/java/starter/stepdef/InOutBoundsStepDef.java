package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class InOutBoundsStepDef {

    @Steps
    MiddlemanAPI middlemanAPI;

    // Get Cart for stock user and admin
    @Given("Get inbound stock for user and admin")
    public void getInboundStockForUserAndAdmin() {
        middlemanAPI.getCartForStockUserAndAdmin();
    }

    @When("Send request get inbound stock for user and admin")
    public void sendRequestGetInboundStockForUserAndAdmin() {
        SerenityRest.when()
                .get(MiddlemanAPI.INOUTBOUNDS);

    }

    // Post Create new inbound stock for user and admin
    @Given("Post create new inbound stock for user and admin with valid request body {string}")
    public void postCreateNewInboundStockForUserAndAdminWithValidRequestBody(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateNewInboundStockForUserAndAdmin(jsonFile);
    }

    @When("Send request post inbound stock for user and admin")
    public void sendRequestPostInboundStockForUserAndAdmin() {
        SerenityRest.when()
                .post(MiddlemanAPI.INOUTBOUNDS);
    }

    // Post Create new inbound stock for user and admin without product id
    @Given("Post create new inbound stock for user and admin with invalid request body {string}")
    public void postCreateNewInboundStockForUserAndAdminWithoutProductId(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateNewInboundStockForUserAndAdminWithoutProductId(jsonFile);

    }

    //Put update product with valid request body
    @Given("Put update product with valid request body {string} and parameter {int}")
    public void putUpdateProductWithValidRequestBody(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateProductWithValidRequestBody(id, jsonFile);
    }

    @When("Send request put update product with valid request body")
    public void sendRequestPutUpdateProductWithValidRequestBody() {
        SerenityRest.when()
                .put(MiddlemanAPI.INOUTBOUNDS_ID);
    }

    //Put update product with invalid request body
    @Given("Put update product with invalid request body {string} and parameter {int}")
    public void putUpdateProductWithInvalidRequestBody(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateProductWithInvalidRequestBody(id, jsonFile);
    }


    @Given("Delete product with valid product id {int}")
    public void deleteProductWithValidProductId(int id) {
        middlemanAPI.deleteProductWithValidProductId(id);

    }

    @When("Send request delete product with valid id")
    public void sendRequestDeleteProductWithValidId() {
        SerenityRest.when()
                .delete(MiddlemanAPI.INOUTBOUNDS_ID);
    }


}
