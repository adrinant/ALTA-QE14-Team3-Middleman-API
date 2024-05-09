package starter.middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.stepdef.AuthStepDef;
import starter.utils.Constants;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MiddlemanAPI {
    public static String LOGIN = Constants.BASE_URL + "/login";
    public static String REGISTER = Constants.BASE_URL + "/register";
    public static String USERS = Constants.BASE_URL + "/users";
    public static String USERS_PRODUCTS = Constants.BASE_URL + "/users/products";
    public static String USERS_PRODUCTS_SEARCH = Constants.BASE_URL + "/users/products/search";
    public static String USERS_PRODUCTS_ID = Constants.BASE_URL + "/users/products/{id}";
    public static String ADMIN_PRODUCTS = Constants.BASE_URL + "/admins/products";
    public static String ADMIN_PRODUCTS_SEARCH = Constants.BASE_URL + "/admins/products/search";
    public static String ADMIN_PRODUCTS_ID = Constants.BASE_URL + "/admins/products/{id}";
    public static String CARTS = Constants.BASE_URL + "/carts";
    public static String CARTS_ID = Constants.BASE_URL + "/carts/{id}";
    public static String ORDERS = Constants.BASE_URL + "/orders/users";
    public static String ORDERS_ID = Constants.BASE_URL + "/orders/{id}";
    public static String ORDERS_ADMINS = Constants.BASE_URL + "/orders/admins";
    public static String ORDERS_ADMINS_INCOMING = Constants.BASE_URL + "/orders/admins/incoming";
    public static String ORDERS_CONFIRM = Constants.BASE_URL + "/orders/confirm/{id}";
    public static String ORDERS_DONE = Constants.BASE_URL + "/orders/done/{id}";
    public static String INOUTBOUNDS = Constants.BASE_URL + "/inoutbounds";
    public static String INOUTBOUNDS_ID = Constants.BASE_URL + "/inoutbounds/{id}";
    public static String USERS_INVENTORY = Constants.BASE_URL + "/users/inventory";
    public static String USERS_INVENTORY_ID = Constants.BASE_URL + "/users/inventory/{id}";
    public static String ADMINS_INVENTORY = Constants.BASE_URL + "/admins/inventory";
    public static String ADMINS_INVENTORY_ID = Constants.BASE_URL + "/admins/inventory/{id}";

    //                                                                      AUTH                                                                //
    //Login
    @Step("Get User profile")
    public void getUserProfiles() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }


    //                                                                      USERS                                                               //
    //Update User
    @Step("Login Middleman API")
    public void loginMiddlemanAPI(File JSON) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("put Update user")
    public void putUpdateUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete User
    @Step("delete User")
    public void deleteUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    //                                                                      ADMINS_PRODUCTS
    //Update Product Positive
    @Step("post Add Product By Admin")
    public void postAddProductByAdmin(String product_name, String unit, String stock, String price, File images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    // Update Product Negative
    @Step("post Add Product By Admin with invalid data")
    public void postAddProductByAdmin(String unit, String stock, String price, File images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);

    }

    // Get all admins products
    @Step("get update products by admin")
    public void getAdminProducts() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    // Get search product data
    @Step("get search product data by admin")
    public void getSearchProductData() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    // Put Update Product By Admin
    @Step("put Update Product By Admin")
    public void putUpdateProductByAdmin(String product_name, String unit, String stock, String price, File images, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    @Step("put Update Product Invalid By Admin")
    public void putUpdateProductInvalidByAdmin(String product_name, String unit, String stock, String price, File images, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    // Delete User Product by Admin
    @Step("delete product by id")
    public void deleteProductById(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id);
    }

    // Get Cart for stock user and admin
    @Step("Get Cart for stock user and admin")
    public void getCartForStockUserAndAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    // Post Create new inbound stock Positive
    @Step("Post Create new inbound stock for user and admin")
    public void postCreateNewInboundStockForUserAndAdmin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Post create new inbound stock Negative
    @Step("Post create new inbound stock for user and admin without product id")
    public void postCreateNewInboundStockForUserAndAdminWithoutProductId(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Put Update request Body Positive
    @Step("Put update product with valid request body")
    public void putUpdateProductWithValidRequestBody(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }

    // Put update request body negative
    @Step("put update product with invalid request body")
    public void putUpdateProductWithInvalidRequestBody(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Delete Product By Valid Product Id
    @Step("delete product with valid product id")
    public void deleteProductWithValidProductId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id);

    }

    // Create Inventories form by user
    @Step("Create invetories form by user")
    public void postCreateInventoriesFormUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Create inventories with invalid request body by user
    @Step("Create Inventories with invalid request body")
    public void postCreateInventoriesInvalidFormUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Get all product forms
    @Step("Get all product forms from inventory by user")
    public void getAllProdutFormsByUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    //  Get detailed product from inventory
    @Step("Get detailed product from inventory by user and set parameter to {int}")
    public void getDetailedProductByUser(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id);
    }

    // Create a form to list product by admin
    @Step("Create a form to list product by admin with valid json {string")
    public void PostCreateFormByAdmin(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Get All products forms by admin
    @Step("Get all product forms from inventory by admin")
    public void getAllProductFormsByAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    // Get detailed product from inventory by admin
    @Step("Get detailed product from inventory by admin")
    public void getDetailedProductByAdmin(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id);
    }
}