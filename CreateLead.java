package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
	public static ChromeDriver driver;
	public static void openUrl() {
		// Setup the Driver
		WebDriverManager.chromedriver().setup(); 
				
		// Open Browser and Launch URL
		driver=new ChromeDriver(); 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	}
	public static void login() {
		// Enter Credentials and Login 
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");  // Enter UserName 
        driver.findElement(By.id("password")).sendKeys("crmsfa");   //Enter Password
        driver.findElement(By.className("decorativeSubmit")).click();  //Click Login Button
	}
	public static void navigateToLeadsPage() {
		//Navigate to Leads Page
        driver.findElement(By.linkText("CRM/SFA")).click();  //Click CRM/SFA Link
        driver.findElement(By.linkText("Leads")).click();   //Click on Leads Tab
	}
	public static void navigateToCreateLeadPage() {
		//Navigate to Create Lead Page
        driver.findElement(By.linkText("Create Lead")).click();
	}
	public static void enterLeadDetailsCreateLead() {
		//Enter the Lead details
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");   //Enter Company Name
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ramya");   //Enter First Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("J");   //Enter Last Name
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("RamyaJ");   //Enter First Name(Local)
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software Testing");   //Enter Department 
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Responsible foo software testing");  //Enter Description
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ramya.spj@gmail.com");   //Enter Email Id
        Select elementState = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));  //Select State/Province
		elementState.selectByVisibleText("New York");
		
		//Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();
				
		//Get the Title of Resulting Page.
		System.out.println("Page Title is - "+driver.getTitle());
	}
	public static void main(String[] args) {
		// Open Browser and Launch URL
		openUrl();
		
		// Enter Credentials and Login
		login();
		
		//Navigate to Leads Page
		navigateToLeadsPage();
		
		//Navigate to Create Lead Page
		navigateToCreateLeadPage();
		
		//Enter the Lead details and Create Lead
		enterLeadDetailsCreateLead();

	}

}
