package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {

	public static By signInLink = By.xpath("//span[contains(text(),'Hello. Sign in')]");
	public static By username = By.xpath("//input[@id='ap_email']");
	public static By contBttn = By.xpath("//input[@id='continue']");
	public static By password = By.xpath("//input[@id='ap_password']");
	public static By loginbutton = By.xpath("//input[@id='signInSubmit']");
	public static By MENU_ICON = By.xpath("//a[@id='nav-hamburger-menu']");
	public static By MENU_LIST = By.xpath("//div[@id='hmenu-content']");
	public static By MENU_MOB = By.xpath("//ul[contains(@class,'hmenu-visible')]//li[8]//a[1]");
	public static By MENU_MOB2 = By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//li[17]//a[1]");
	public static By MENU_LIST1 = By.xpath("//ul[@class='hmenu  hmenu-visible']//li//a");
	public static By MENU_LIST2 = By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//li//a");
	public static By priceDropdown = By.xpath("//span[@class='a-dropdown-label']");
	public static By priceDropdownList = By.xpath("//ul[@class='a-nostyle a-list-link']//li");
	public static By buyNowBttn=By.xpath("//input[@id='buy-now-button']");

	public static By lowestPrice = By.xpath(
			"//span[@class='celwidget slot=SEARCH_RESULTS template=SEARCH_RESULTS widgetId=search-results index=0']//span[@class='a-price-whole']");

	

	public static WebElement cpuTypeCheckbox(WebDriver driver) {

		WebElement cpuTypeCheckbox;
		cpuTypeCheckbox = driver.findElement(By.xpath("//span[contains(text(),'Intel Core i7')]"));
		return cpuTypeCheckbox;
	}
	
	
	
	public static WebElement memorySizeCheckBox(WebDriver driver) {

		WebElement memorySizeCheckBox;
		memorySizeCheckBox = driver
				.findElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'8 GB')]"));
		return memorySizeCheckBox;
	}

	
	public static WebElement displaySizeCheckBox1(WebDriver driver) {

		WebElement displaySizeCheckBox1;
		displaySizeCheckBox1 = driver.findElement(By.xpath("//span[contains(text(),'Up to 10')]"));
		return displaySizeCheckBox1;
	}
	
	
	
	public static WebElement displaySizeCheckBox2(WebDriver driver) {

		WebElement displaySizeCheckBox2;
		displaySizeCheckBox2 = driver.findElement(By.xpath("//span[contains(text(),'13\" - 14')]"));
		return displaySizeCheckBox2;
	}
	
	
	

	
	
}
