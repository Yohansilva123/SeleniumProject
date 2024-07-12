package Test;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import TestData.UserCredentials;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {


    @Test
    public void LoginWithValidUser(){
        SoftAssert softAssert = new SoftAssert();
        LoginPage.login(UserCredentials.validLoginUserName, UserCredentials.validLoginUserPassword);
        softAssert.assertTrue(HomePage.isHomeIconVisible(), "Home button is not visible");
        HomePage.selectItemByName("Sauce Labs Backpack");
    }
}
