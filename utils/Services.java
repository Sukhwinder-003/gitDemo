package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services {

	static ConfigFileReader config = new ConfigFileReader();
	static WebDriver driver;
	public static WebElement cpuTypeCheckbox;
	public static WebElement memorySizeCheckBox;
	public static WebElement displaySizeCheckBox1;
	public static WebElement displaySizeCheckBox2;

	// This method is to initialize the driver
	public static void driverInitialization() {
		System.setProperty("webdriver.chrome.driver", config.getDriverPath());

		// Here driver is an reference of an interface which is holding the
		// chromeDriver object
		// ChromeDriver is an implementation class of WebDriver Interface

		driver = new ChromeDriver();
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driverInitialization();
		}
		return driver;
	}

	public static void initializeDriver() {

		getDriver();


	}

	public static void clickElement(By element) {

		driver.findElement(element).click();

	}

	public static void login(boolean value) {

		if (value == true) {

			driver.manage().window().maximize();
			driver.get(config.getURL());
			driver.navigate().refresh();
			applyImplicitWait();
			driver.findElement(Locators.signInLink).click();
			driver.findElement(Locators.username).sendKeys(config.getvalidUsername());
			driver.findElement(Locators.contBttn).click();
			driver.findElement(Locators.password).sendKeys(config.getvalidPassword());
			driver.findElement(Locators.loginbutton).click();
		}

		else {
			driver.manage().window().maximize();
			driver.get(config.getURL());
		}

	}

	public static void applyWait(By Xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Xpath));

	}

	public static void applyImplicitWait() {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	// This method is used to hold the list of elements
	public static void getDataFromList(By List, String Text) {

		List<WebElement> list = driver.findElements(List);

		for (int i = 0; i < list.size(); i++)

		{

			if (list.get(i).getText().contains(Text)) {
				list.get(i).click();
				break;
			}
		}

	}

	public static void selectCheckBox(WebElement element) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("window.scrollBy(0,-100);", element);
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(element).click().build().perform();

	}

	public static void getProcessorCheckbox() {

		cpuTypeCheckbox = Locators.cpuTypeCheckbox(driver);

	}

	public static void getRAMCheckBox() {

		memorySizeCheckBox = Locators.memorySizeCheckBox(driver);

	}

	public static void displaySizeCheckBox1() {

		displaySizeCheckBox1 = driver.findElement(By.xpath("//span[contains(text(),'Up to 10')]"));

	}

	public static void displaySizeCheckBox2() {

		displaySizeCheckBox2 = driver.findElement(By.xpath("//span[contains(text(),'13\" - 14')]"));

	}

	public static String getText(By xpath) {

		String text = driver.findElement(xpath).getText();

		return text;

	}

	public static void closeBrowser() {

		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;

	}

	public static void handleWindow(By elementToClick) throws InterruptedException {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		driver.findElement(elementToClick).click();

		applyImplicitWait();

		System.out.println("@@@@@@@@@User Reached At " +getTitle("TITLE") + " Page Hence Closing The Tab Following By Browser@@@@@@@");

		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	public static String getTitle(String bringTheTitle) {

		bringTheTitle = driver.getTitle();

		return bringTheTitle;

	}
}