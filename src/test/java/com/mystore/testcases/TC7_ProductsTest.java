package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AllProductPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.ProductDetailPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC7_ProductsTest extends BaseClass {

    IndexPage indexPage;
    AllProductPage allProductPage;
    ProductDetailPage productDetailPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = {"Smoke"})
    public void verifyAllProductToDetail() {
        Log.startTestCase("verifyAllProductToDetail");

        indexPage = new IndexPage();
        Assert.assertTrue(indexPage.validateLogo());
        allProductPage = indexPage.clickProductsNav();

        Assert.assertTrue(allProductPage.verifyProductPage());
        Log.info("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(allProductPage.isProductAvailable());
        Log.info("Verify the products list is visible");
        productDetailPage = allProductPage.clickViewFirstProduct();

        Log.info("Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        Assert.assertTrue(productDetailPage.verifyProductName());
        Assert.assertTrue(productDetailPage.verifyProductImg());
        Assert.assertTrue(productDetailPage.verifyProductCategory());
        Assert.assertTrue(productDetailPage.verifyProductPrice());
        Assert.assertTrue(productDetailPage.verifyProductAvailability());
        Assert.assertTrue(productDetailPage.verifyProductCondition());
        Assert.assertTrue(productDetailPage.verifyProductBrand());
        Log.info("Verify the products detail is visible");

        Log.endTestCase("verifyAllProductToDetail");

    }

}
