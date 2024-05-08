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

    @Step("Get User profile")
    public void getUserProfiles() {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ AuthStepDef.token);
    }

    @Step("Login Middleman API")
    public void loginMiddlemanAPI(File JSON) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("User Login with email and password")
    public void postUserLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Register")
    public void postRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Get list user products")
    public void getUserProducts(){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AuthStepDef.token);
    }

    @Step("Delete user product")
    public void deleteUserProduct(int id){
        SerenityRest.given().pathParam("id", id).headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Delete user product")
    public void deleteUserProductinvalid(String id){
        SerenityRest.given().pathParam("id", id).headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Search user product")
    public void getSearchUserProduct(String Parameter){
        SerenityRest.given().pathParam("id", Parameter).headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Update user product with valid id")
    public void putUpdateUserProductValidId(int id, String product_name, String unit, String stock, String price){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock",stock)
                .multiPart("price", price);
    }
    @Step("Update user product with invalid id")
    public void putUpdateUserProductInvalidId(String id, String product_name, String unit, String stock, String price){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock",stock)
                .multiPart("price", price);
    }
    @Step("Get carts")
    public void getCarts(){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Create cart valid data")
    public void postCreateCartValidData(String product_id, String qty){
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

    @Step("Delete cart")
    public void deleteCartValidId(int id){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Delete cart")
    public void deleteCartInvalidId(String id){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Create order")
    public void postCreateOrder(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json)
                .headers("Authorization", "Bearer "+AuthStepDef.token);
    }
    @Step("Get all history order by user")
    public void getHistoryOrderByUser(){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AuthStepDef.token);
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
    public void getHistoryOrderByAdmin(){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AuthStepDef.tokenAdmin);
    }
    @Step("Get incoming order from user")
    public void getIncomingOrderByAdmin(){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AuthStepDef.tokenAdmin);
    }
    @Step("Update to confirm order with valid id")
    public void putConfirmOrderValidId(int id){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }
    @Step("Update to confirm order with invalid id")
    public void putConfirmOrderInvalidId(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }
    @Step("Update to finish order with valid id")
    public void putFinishOrderValidId(int id){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }
    @Step("Update to finish order with invalid id")
    public void putFinishOrderInvalidId(String id){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.tokenAdmin);
    }
    @Step("Update cart product quantity with valid id")
    public void putUpdateCartValidId(int id, String qty){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("qty", qty);
    }
    @Step("Update product quantity with invalid id")
    public void putUpdateCartInvalidId(String id, String qty){
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("qty", qty);
    }
    @Step ("post Add Product By User")
    public void postAddProductByUser(String product_name, String unit, String stock, String price, File images){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + AuthStepDef.token)
                .contentType("multipart/form-data")
                .multiPart("product_name", product_name)
                .multiPart("unit", unit)
                .multiPart("stock",stock)
                .multiPart("price", price)
                .multiPart("product_image",images);
    }
}
