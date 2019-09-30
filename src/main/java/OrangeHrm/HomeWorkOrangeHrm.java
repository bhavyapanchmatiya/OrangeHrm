package OrangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWorkOrangeHrm extends UtilsPage {

@BeforeMethod

    public void openBrowser(){

    System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

    openChromeVersion76();
    manageTimeoutImplicity();
    manageWindow();

    driver.get("https://opensource-demo.orangehrmlive.com/");

    enterText(By.id("txtUsername"),"admin");

    enterText(By.id("txtPassword"),"admin123");

    clickElement(By.id("btnLogin"));
}

@Test

    public void UserShouldNotBeAbleToApplyForJobInVacancyRecruitement(){
    //click on Recruitment
    clickElement(By.id("menu_recruitment_viewRecruitmentModule"));
    //click on Vacancies
    clickElement(By.xpath("//a[@href=\"/index.php/recruitment/viewJobVacancy\"]"));
    //Select Dropdown JobTitle: IT Manager
    selectByIndex(By.id("vacancySearch_jobTitle"),7);
    //select dropdown Status
    selectByIndex(By.id("vacancySearch_status"),1);
    //click on Add
    clickElement(By.id("btnAdd"));
    //select dropdown jobTitle: IT manager
    selectByIndex(By.id("addJobVacancy_jobTitle"),7);
    //Type in Vacancy name
    enterText(By.id("addJobVacancy_name"),"Manual Test Manager");
    //Type Hiring Manager Name
    enterText(By.id("addJobVacancy_hiringManager"),"Fiona Grace");
    //Type in Description
    enterText(By.xpath("//textarea[@name=\"addJobVacancy[description]\"]"),"Attaching My CV");
    //Click on Save
    clickElement(By.xpath("//input[@class=\"savebutton\"]"));

    String expectedResultTest1  = ("An internal error occurred. Please contact your system administrator.\nClose");

    String actualResultTest11 = extractText(By.xpath("//div[@class='message error']"));

    Assert.assertEquals(actualResultTest11,expectedResultTest1);
}


@Test

    public void UserShouldBeAbleToLogInAndSearchForEmployeeDetails(){

    clickElement(By.id("menu_directory_viewDirectory"));

    enterText(By.id("searchDirectory_emp_name_empName"),"Fiona Grace");

    clickElement(By.id("searchBtn"));

    String expectedResultest2 = ("Fiona Grace");

    String actualResultTest2 = extractText(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[2]/td[2]/ul/li[1]/b"));

    Assert.assertEquals(actualResultTest2,expectedResultest2);
}

@Test

    public void AdminCanLogInAndEditDetailsOfEmployees(){

    clickElement(By.id("menu_pim_viewPimModule"));

    clickElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[8]/td[3]/a"));

    clickElement(By.id("btnSave"));

    enterText(By.id("personal_txtEmpMiddleName"),"Bhavya");

    clickElement(By.id("btnSave"));

    String expectedResultTest3 = ("Jasmine Bhavya Morgan");

    String actualResultTest3 = extractText(By.id("profile-pic"));

    Assert.assertEquals(actualResultTest3,expectedResultTest3);




}







@AfterMethod

    public void DriverClose(){
    driver.quit();
}








}
