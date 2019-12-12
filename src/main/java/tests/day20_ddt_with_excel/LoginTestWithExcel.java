package tests.day20_ddt_with_excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestWithExcel extends TestBase {

    public static void main(String[] args) {
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx","QA2-short");
        System.out.println("Row count: "+qa2.rowCount());
        System.out.println(qa2.getColumnsNames());
      for(Map<String, String> map: qa2.getDataList()){
          System.out.println(map);
      }
    }

    @Test(dataProvider = "credentials", description = "Login with different credentials")
    public void loginTest(String username, String password, String firstName, String lastName, String result){
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }


    @DataProvider(name = "credential")
    public static Object[][] credentials(){
        ExcelUtil qa2= new ExcelUtil("vytrack_testusers.xlsx","QA2-short");
        return qa2.getDataArray();
    }



}
