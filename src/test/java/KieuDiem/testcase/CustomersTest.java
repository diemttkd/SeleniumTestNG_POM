package KieuDiem.testcase;

import KieuDiem.common.BaseTest;
import KieuDiem.pages.Customer.AddCustomerPage;
import KieuDiem.pages.Customer.CustomerDetailPage;
import KieuDiem.pages.Customer.CustomersPage;
import KieuDiem.pages.DashboardPage;
import KieuDiem.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {
    CustomersPage customersPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddCustomerPage addCustomerPage;
    CustomerDetailPage customerDetailPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        customersPage = dashboardPage.openCustomerPage();

        //Kiểm tra trang Customer Pagee load được hay chưa và đúng hay chưa
        customersPage.verifyCustomerPage();
        //Click vào button New Customer
        addCustomerPage = customersPage.clickNewCustomerButton();

        String CUSTOMER_NAME = "Java";
        addCustomerPage.addDataNewCustomer(CUSTOMER_NAME);

        //Mở lại trang Customer
        dashboardPage.openCustomerPage();
        //Search giá trị Customer vừa add
        customersPage.searchCustomer(CUSTOMER_NAME);
        //Click vào giá trị Customer name dòng đầu tiên
        customerDetailPage = customersPage.clickOnFirstRowCustomerName();
        //Check customer deatil
        customerDetailPage.checkCustomerDetail(CUSTOMER_NAME);
    }
}
