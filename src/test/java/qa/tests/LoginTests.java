package qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pages.LoginPage;
import qa.pages.ProductsPage;

public class LoginTests extends BaseTest {

    @Test
    public void invalidUserName() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginBtn();
        Assert.assertEquals(loginPage.getErrTxt(),
                strings.get("err_invalid_username_or_password"));
    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressLoginBtn();
        Assert.assertEquals(loginPage.getErrTxt(),
                strings.get("err_invalid_username_or_password"));
    }

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
        loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
        ProductsPage productsPage = loginPage.pressLoginBtn();
     //   DeepLink.login();
     //   ProductsPage productsPage = new ProductsPage();
        Assert.assertEquals(productsPage.getTitle(), strings.get("product_title"));
    }
}
