package week2.day1;

import org.openqa.selenium.By;


public class EditLead {
	
	static void editLeadAndUpdate() {
		//Click on Edit Button
		CreateLead.driver.findElement(By.linkText("Edit")).click(); 
				
		//Clear Description and Fill Important Note
		CreateLead.driver.findElement(By.id("updateLeadForm_description")).clear();
		CreateLead.driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Responsible for R&D Team"); 
				
		//Click on Update Button
		CreateLead.driver.findElement(By.className("smallSubmit")).click();
				
		//Get the Title of Resulting Page.
		System.out.println("Page Title is - "+CreateLead.driver.getTitle());
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

       //Edit Lead description, Important Note and update
		editLeadAndUpdate();
	}

}
