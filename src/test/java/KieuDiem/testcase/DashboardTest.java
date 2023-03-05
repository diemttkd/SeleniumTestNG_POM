package KieuDiem.testcase;

import KieuDiem.common.BaseTest;
import KieuDiem.pages.Customer.CustomersPage;
import KieuDiem.pages.DashboardPage;
import KieuDiem.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    DashboardPage dashboarpage;
    LoginPage loginPage;
    CustomersPage customerpage;

   @Test
    public void testOpenMenuOnDashboard(){
       loginPage = new LoginPage(driver);

       //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang dashboard
       dashboarpage = loginPage.loginCRM("admin@example.com", "123456");
       //Kiểm tra Dashboard là đúng
       dashboarpage.verifyDashboardPage();
       //Kiểm tra mở trang Customer
       customerpage = dashboarpage.openCustomerPage();

       customerpage.verifyCustomerPage();
    }
    @Test
    public void filterWidgetOnDashboard(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboarpage = new DashboardPage(driver);
        //Kiểm tra Dashboard
        dashboarpage.verifyDashboardPage();
        //Check filter widget on dashboard
        dashboarpage.verifyDashboardPage();
    }
}
