package starter.middleman;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.stepdef.AuthStepDef;
import starter.utils.Constants;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MiddlemanAPI {
    public static String LOGIN = Constants.BASE_URL + "/login";
    public static String REGISTER = Constants.BASE_URL + "/register";
    public static String USERS = Constants.BASE_URL + "/users";
    public static String USERS_PRODUCTS = Constants.BASE_URL + "/users/products";
    public static String USERS_PRODUCTS_SEARCH = Constants.BASE_URL + "/users/products/search?{param}";
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

    //Authentication
    @Step("User Login with email and password")
    public void postUserLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register with valid data")
    public void postUserRegister(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //============================================================================//

    //Users

    @Step("Get User profile")
    public void getUserProfiles() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenDelete);
    }

    @Step("Put Update user")
    public void putUpdateUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenDelete)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenDelete);
    }

    //============================================================================//

    //Users Product
    @Step("Get list user products")
    public void getUserProducts() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Post Add Product By User")
    public void postAddProductByUser(String product_name, String unit, String stock, String price, File images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    @Step("Update user product with valid id")
    public void putUpdateUserProductValidId(int id, String product_name, String unit, String stock, String price, File imageFile) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", imageFile);
    }

    @Step("Search user product")
    public void getSearchUserProduct(String Parameter) {
        SerenityRest.given().pathParam("param", Parameter).headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("User Delete user product")
    public void deleteUserProduct(int id) {
        SerenityRest.given().pathParam("id", id).headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("User Delete user product")
    public void deleteUserProductinvalid(String id) {
        SerenityRest.given().pathParam("id", id).headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    //============================================================================//

    //Admins Product
    @Step("post Add Product By Admin")
    public void postAddProductByAdmin(String product_name, String unit, String stock, String price, File images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    @Step("Post Add Product By Admin with invalid data")
    public void postAddProductByAdmin(String unit, String stock, String price, File images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .contentType("multipart/form-data")
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    @Step("Get update products by admin")
    public void getAdminProducts() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Get search product data by admin")
    public void getSearchProductData() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Put Update Product By Admin")
    public void putUpdateProductByAdmin(String product_name, String unit, String stock, String price, File images, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock", stock)
                .multiPart("price", price)
                .multiPart("product_image", images);
    }

    @Step("Put Update Product Invalid By Admin")
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

    @Step("Admin Delete product by id")
    public void deleteProductById(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .pathParam("id", id);
    }

    //============================================================================//

    //Carts

    @Step("Get carts")
    public void getCarts() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Create cart valid data")
    public void postCreateCartValidData(String product_id, String qty) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_id", product_id)
                .multiPart("qty", qty);
    }

    @Step("Create cart invalid data")
    public void postCreateCartInvalidData(String qty) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("qty", qty);
    }

    @Step("Update cart product quantity with valid id")
    public void putUpdateCartValidId(int id, String qty) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("qty", qty);
    }

    @Step("Update product quantity with invalid id")
    public void putUpdateCartInvalidId(String id, String qty) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("qty", qty);
    }

    @Step("Delete cart")
    public void deleteCartValidId(int id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Delete cart")
    public void deleteCartInvalidId(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    //============================================================================//

    //Orders
    @Step("Create order")
    public void postCreateOrder(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json)
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Get all history order by user")
    public void getHistoryOrderByUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Get detail order with valid id")
    public void getDetailOrderValidId(int id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Get detail order with invalid id")
    public void getDetailOrderInvalidId(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token);
    }

    @Step("Get all history order by admin")
    public void getHistoryOrderByAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Get incoming order from user")
    public void getIncomingOrderByAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Update to confirm order with valid id")
    public void putConfirmOrderValidId(int id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Update to confirm order with invalid id")
    public void putConfirmOrderInvalidId(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Update to finish order with valid id")
    public void putFinishOrderValidId(int id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Update to finish order with invalid id")
    public void putFinishOrderInvalidId(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    //============================================================================//

    //InOutbounds

    //Inbounds
    @Step("Get inbounds outbounds")
    public void getInboundsOutbounds() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    @Step("Post create new admin inbounds")
    public void postCreateNewAdminInbounds(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new admin inbounds without product id")
    public void postCreateNewAdminInboundsWithoutProductId(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update admin inbounds product quantity with valid request body")
    public void putUpdateAdminInboundsProductQuantityWithValidRequestBody(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update admin inbounds product quantity with invalid request body")
    public void putUpdateAdminInboundsProductQuantityWithInvalidRequestBody(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete admin product inbounds by id")
    public void deleteAdminProductInboundsByValidId(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .pathParam("id", id);
    }

    //Outbounds
    @Step("Post create new user outbounds")
    public void postCreateNewUserOutbounds(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create new user outbounds without product id")
    public void postCreateNewUserOutboundsWithoutProductId(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user outbounds product quantity with valid request body")
    public void putUpdateUserOutboundsProductQuantityWithValidRequestBody(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user outbounds product quantity with invalid request body")
    public void putUpdateUserOutboundsProductQuantityWithInvalidRequestBody(int id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user inbound product by valid id")
    public void deleteUserOutboundsProduct(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .pathParam("id", id);
    }

    //============================================================================//

    //Inventories

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
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .contentType(ContentType.JSON)
                .body(json);
    }

    // Get All products forms by admin
    @Step("Get all product forms from inventory by admin")
    public void getAllProductFormsByAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }

    // Get detailed product from inventory by admin
    @Step("Get detailed product from inventory by admin")
    public void getDetailedProductByAdmin(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin)
                .pathParam("id", id);
    }

}