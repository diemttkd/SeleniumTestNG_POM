package KieuDiem.testcase;

import KieuDiem.common.BaseTest;
import KieuDiem.pages.LoginFactoryPage;
import org.testng.annotations.Test;

public class LoginTestFactory extends BaseTest {
    LoginFactoryPage loginFactoryPage;
    @Test
    public void testLoginSuccess(){
        loginFactoryPage = new LoginFactoryPage(driver);
        loginFactoryPage.loginSuccess("admin@example.com", "123456");
    }
}
