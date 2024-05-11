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

    @Given("Get admin products inbounds")
    public void getAdminProductsInbounds() {
        middlemanAPI.getInboundsOutbounds();
    }

    @When("Send request get admin inbounds")
    public void sendRequestGetAdminInbounds() {
        SerenityRest.when()
                .get(MiddlemanAPI.INOUTBOUNDS);

    }

    //Inbounds
    @Given("Post create new admin inbounds with valid request body {string}")
    public void postCreateNewInboundStockForUserAndAdminWithValidRequestBody(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateNewAdminInbounds(jsonFile);
    }

    @When("Send request post inbound")
    public void sendRequestPostInbound() {
        SerenityRest.when()
                .post(MiddlemanAPI.INOUTBOUNDS);
    }

    @Given("Post create new admin inbounds without product id with invalid request body {string}")
    public void postCreateNewInboundStockForUserAndAdminWithoutProductId(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateNewAdminInboundsWithoutProductId(jsonFile);
    }

    @Given("Put update admin inbounds product quantity with valid request body {string} and parameter {int}")
    public void putUpdateInboundsProductWithValidRequestBody(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateAdminInboundsProductQuantityWithValidRequestBody(id, jsonFile);
    }

    @When("Send request put update inbounds")
    public void sendRequestPutUpdateInbounds() {
        SerenityRest.when()
                .put(MiddlemanAPI.INOUTBOUNDS_ID);
    }

    @Given("Put update admin inbounds product quantity with invalid request body {string} and parameter {int}")
    public void putUpdateInboundsProductWithInvalidRequestBody(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateAdminInboundsProductQuantityWithInvalidRequestBody(id, jsonFile);
    }

    @Given("Delete admin product inbounds by id {int}")
    public void deleteAdminProductInboundsById(int id) {
        middlemanAPI.deleteAdminProductInboundsByValidId(id);

    }

    @When("Send request delete inbounds")
    public void sendRequestDeleteInbounds() {
        SerenityRest.when()
                .delete(MiddlemanAPI.INOUTBOUNDS_ID);
    }

    //Outbounds
    @Given("Get user products outbounds")
    public void getUserProductsOutbounds() {
        middlemanAPI.getInboundsOutbounds();
    }


    @When("Send request get user outbounds")
    public void sendRequestGetUserOutbounds() {
        SerenityRest.when()
                .get(MiddlemanAPI.INOUTBOUNDS);
    }

    @Given("Post create new user outbounds with valid request body {string}")
    public void postCreateNewUserOutboundsWithValidRequestBody(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateNewUserOutbounds(jsonFile);
    }

    @When("Send request post outbounds")
    public void sendRequestPostOutbounds() {
        SerenityRest.when()
                .post(MiddlemanAPI.INOUTBOUNDS);
    }

    @Given("Post create new user outbounds without product id with invalid request body {string}")
    public void postCreateNewUserOutboundsWithoutProductIdWithInvalidRequestBody(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateNewUserOutboundsWithoutProductId(jsonFile);
    }

    @Given("Put update user outbounds product quantity with valid request body {string} and parameter {int}")
    public void putUpdateUserOutboundsProductQuantityWithValidRequestBodyAndParameter(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateUserOutboundsProductQuantityWithValidRequestBody(id, jsonFile);
    }

    @When("Send request put update outbounds")
    public void sendRequestPutUpdateOutbounds() {
        SerenityRest.when()
                .put(MiddlemanAPI.INOUTBOUNDS_ID);
    }

    @Given("Put update user outbounds product quantity with invalid request body {string} and parameter {int}")
    public void putUpdateUserOutboundsProductQuantityWithInvalidRequestBodyAndParameter(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.putUpdateUserOutboundsProductQuantityWithInvalidRequestBody(id, jsonFile);
    }

    @Given("Delete user product outbounds by id {int}")
    public void deleteUserProductOutboundsById(int id) {
        middlemanAPI.deleteUserOutboundsProduct(id);
    }

    @When("Send request delete outbounds")
    public void sendRequestDeleteOutbounds() {
        SerenityRest.when()
                .delete(MiddlemanAPI.INOUTBOUNDS_ID);
    }
}