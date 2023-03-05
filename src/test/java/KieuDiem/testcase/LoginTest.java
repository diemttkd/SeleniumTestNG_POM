package KieuDiem.testcase;

import KieuDiem.common.BaseTest;
import KieuDiem.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginpage;
    @Test
    public void LoginTestSuccess(){
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginpage = new LoginPage(driver);

        //Gọi hàm login từ trang LoginPage để sử dụng
        loginpage.loginCRM("admin@example.com", "123456");
    }
    @Test
    public void LoginTestInvalidEmail(){
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginpage = new LoginPage(driver);

        //Gọi hàm login từ trang LoginPage để sử dụng
        loginpage.loginCRM("admin@example.com1234", "123456");
    }

}
