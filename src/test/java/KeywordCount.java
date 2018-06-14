import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeywordCount {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		List<String> keyword = new ArrayList<>();
		keyword.add("Data Analyst");
		keyword.add("Project Manager");
		keyword.add("Scrum Master");
		keyword.add("Tech Team Lead Position");
		keyword.add("IT Director");
		keyword.add("IT Systems Administrator");
		keyword.add("Cloud Architect");
		keyword.add("Selenium");
		keyword.add("Computer Network Architect");
		keyword.add("SDET");
		keyword.add("Manual Tester");
		keyword.add("Cloud Consultant");
		keyword.add("Java Developer");
		keyword.add("Javascript");
		keyword.add("Senior Automation Tester");
		keyword.add("Front End Developer");
		keyword.add("Back End Developer");
		keyword.add("Database Engineer");
		keyword.add("Technical Specialist");
		keyword.add("Associate Developer");
		
		List<String> newKeywords=new ArrayList<>();
		
		
		for(int i=0; i<keyword.size(); i++){
			String url="https://dice.com";
			driver.get(url);
			driver.findElement(By.id("search-field-keyword")).clear();
			driver.findElement(By.id("search-field-keyword")).sendKeys(keyword.get(i));
			String location = "22102";
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys(location);
			driver.findElement(By.id("findTechJobs")).click();
			String count = driver.findElement(By.id("posiCountId")).getText();
			newKeywords.add(keyword.get(i)+"-"+count.replaceAll(",", ""));	
			
		}
		
		System.out.println(newKeywords);
		
		//===========Reading from .txt file=============
		
		List<String> ReadnewKeywords=new ArrayList<>();
		
		try {
			FileReader reader = new FileReader("ITjobs.txt");
			BufferedReader br = new BufferedReader(reader);
			String str;
			while((str=br.readLine())!=null) {
			String url="https://dice.com";
			driver.get(url);
			driver.findElement(By.id("search-field-keyword")).clear();
			driver.findElement(By.id("search-field-keyword")).sendKeys(str);
			String location = "22102";
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys(location);
			driver.findElement(By.id("findTechJobs")).click();
			String count = driver.findElement(By.id("posiCountId")).getText();
			ReadnewKeywords.add(str+"-"+count.replaceAll(",", ""));	
			}
		}catch(IOException e) {
			System.out.println("FileNotFound");
		}
			
		driver.close();
		System.out.println(ReadnewKeywords);
			
		
		
		
		
	

	}

}
