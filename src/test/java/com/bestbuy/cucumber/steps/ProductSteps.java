package com.bestbuy.cucumber.steps;

import com.bestbuy.productinfo.ProductsSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class ProductSteps {

    static ValidatableResponse response;
    static int id;


    @Steps
    ProductsSteps productsSteps;


    @When("^I send the GET request on the product end point$")
    public void iSendTheGETRequestOnTheProductEndPoint() {
        response = productsSteps.getAllProducts();
    }

    @Then("^I must get back the valid status code (\\d+)$")
    public void iMustGetBackTheValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^I create a new product by providing information name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacturer \"([^\"]*)\" model \"([^\"]*)\" url \"([^\"]*)\" image \"([^\"]*)\"$")
    public void iCreateANewProductByProvidingInformationNameTypePriceShippingUpcDescriptionManufacturerModelUrlImage(String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        response = productsSteps.createProduct(name,type,price,shipping,upc,description,manufacturer,model,url,image);
       id = response.extract().path("id");
        System.out.println(" new id  is " + id);


    }

    @Then("^I verify the product with product id$")
    public void iVerifyTheProductWithProductId() {
        response.statusCode(201);
        productsSteps.getProductById(id).log().all();

    }

    @And("^I update the created product by providing information name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacturer \"([^\"]*)\" model \"([^\"]*)\" url \"([^\"]*)\" image \"([^\"]*)\"$")
    public void iUpdateTheCreatedProductByProvidingInformationNameTypePriceShippingUpcDescriptionManufacturerModelUrlImage(String _name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {
      String  name = "_updated";
            productsSteps.updateProduct(id,name,type,price,shipping,upc,description,manufacturer,model,url,image);
    }

    @And("^I delete the created product from the product list$")
    public void iDeleteTheCreatedProductFromTheProductList() {
        productsSteps.deleteProduct(id);
        response.log().all();
        productsSteps.getProductById(id);
    }
}
