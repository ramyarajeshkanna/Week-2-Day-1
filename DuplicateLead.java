package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DuplicateLead {
	static void duplicateLeadAndUpdate() {
		//Click on Duplicate Button
		CreateLead.driver.findElement(By.linkText("Duplicate Lead")).click(); 
				
		//Clear and modify Company name and First name
		WebElement elementCompanyName = CreateLead.driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.clear();
		elementCompanyName.sendKeys("Amazon");
		
		WebElement elementFirstName = CreateLead.driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.clear();
		elementFirstName.sendKeys("Rajesh");
				
		//Click on Create Button
		CreateLead.driver.findElement(By.className("smallSubmit")).click();
				
		//Get the Title of Resulting Page.
		System.out.println("Page Title is - "+CreateLead.driver.getTitle());
	}
	static void verifyDuplicateLead() {
		WebElement elementUpdatedFirstName = CreateLead.driver.findElement(By.id("viewLead_firstName_sp"));
		if(elementUpdatedFirstName.getText().equals("Rajesh"))
			System.out.println("Test Case PASS");
		else
			System.out.println("Test Case FAIL");
	}
	public static void main(String[] args) {
		// Open Browser and Launch URL
		CreateLead.openUrl();
						
		// Enter Credentials and Login
		CreateLead.login();
		
		//Navigate to Leads Page
		CreateLead.navigateToLeadsPage();
		
		//Navigate to Create Lead Page
		CreateLead.navigateToCreateLeadPage();
						
		//Enter the Lead details and Create Lead
		CreateLead.enterLeadDetailsCreateLead();
		
		//Duplicate Lead and update details
		duplicateLeadAndUpdate();
		
		//Verify Duplicated Lead is updated
		verifyDuplicateLead();

	}

}
