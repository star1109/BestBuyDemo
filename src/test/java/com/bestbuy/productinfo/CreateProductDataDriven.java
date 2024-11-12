package com.bestbuy.productinfo;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDriven extends TestBase {

    private String name;
    private String type;
    private int price;
    private int shipping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;

    @Steps
    ProductsSteps productsSteps;

    @Title("Data driven test for adding multiple Products to the application")
    @Test
    public void createMultipleProduct()
    {
        productsSteps.createProduct(name,type,price,shipping,upc,description,manufacturer,model,url,image).statusCode(201);
    }
}
