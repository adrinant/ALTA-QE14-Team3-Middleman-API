package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.middleman.MiddlemanAPI;
import starter.utils.Constants;

import java.io.File;

public class InventoriesStepDef {
    @Steps
    MiddlemanAPI middlemanAPI;

    // Create form to list user product - Positive
    @Given("Create form to list user product with valid request body by user and with valid json {string}")
    public void createFormToListUserProductWithValidRequestBodyByUserAndWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateInventoriesFormUser(jsonFile);

    }

    @When("Send request post create form")
    public void sendRequestPostCreateForm() {
        SerenityRest.when()
                .post(MiddlemanAPI.USERS_INVENTORY);

    }

    // Create form to list user product - Negative
    @Given("Create form to list user product by user and with invalid json {string}")
    public void createFormToListUserWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.postCreateInventoriesInvalidFormUser(jsonFile);
    }


    // Get all product forms by user from inventory
    @Given("Get all product forms from inventory by user")
    public void getAllProductFormsFromInventory() {
        middlemanAPI.getAllProdutFormsByUser();
    }

    @When("Send request get all product forms")
    public void sendRequestGetAllProductForms() {
        SerenityRest.when()
                .get(MiddlemanAPI.USERS_INVENTORY);
    }

    //  Get detailed product from inventory
    @Given("Get detailed product from inventory by user and set parameter to {int}")
    public void getDetailedProductFromInventoryAndSetParameterTo(int id) {
        middlemanAPI.getDetailedProductByUser(id);
    }

    @When("Send request get detailed product from inventory id")
    public void sendRequestGetDetailedProductFromInventoryId() {
        SerenityRest.when()
                .get(MiddlemanAPI.USERS_INVENTORY_ID);
    }

    // Create a form to list product by admin
    @Given("Create a form to list product by admin with valid json {string}")
    public void createAFormToListProductByAdminWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY + json);
        middlemanAPI.PostCreateFormByAdmin(jsonFile);
    }

    @When("Send request post create form by admin")
    public void sendRequestPostCreateFormByAdmin() {
        SerenityRest.when()
                .post(MiddlemanAPI.ADMINS_INVENTORY);
    }

    // Get All products forms by admin
    @Given("Get all product forms from inventory by admin")
    public void getAllProductFormsFromInventoryByAdmin() {
        middlemanAPI.getAllProductFormsByAdmin();
    }

    @When("Send request get all product forms by admin")
    public void sendRequestGetAllProductFormsByAdmin() {
        SerenityRest.when()
                .get(MiddlemanAPI.ADMINS_INVENTORY);
    }

    // Get detailed product from inventory by admin
    @Given("Get detailed product from inventory by admin and set parameter to {int}")
    public void getDetailedProductFromInventoryByAdminAndSetParameterTo(int id) {
        middlemanAPI.getDetailedProductByAdmin(id);
    }

    @When("Send request get detailed product inventory forms")
    public void sendRequestGetDetailedProductInventoryForms() {
        SerenityRest.when()
                .get(MiddlemanAPI.ADMINS_INVENTORY_ID);
    }


}
