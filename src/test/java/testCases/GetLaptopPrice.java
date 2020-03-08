package testCases;

import org.testng.annotations.Test;
import utils.ConfigFileReader;
import utils.Locators;
import utils.Services;

public class GetLaptopPrice {

	static ConfigFileReader config = new ConfigFileReader();
	
	@Test(priority = 1)

	void verifyLowestPriceWithGuest() throws InterruptedException {

		Services.initializeDriver();
		Services.login(false);
		Services.applyImplicitWait();
		Services.clickElement(Locators.MENU_ICON);
		Services.applyImplicitWait();
		Services.getDataFromList(Locators.MENU_LIST1, "Mobiles, Computer");
		Services.applyWait(Locators.MENU_LIST2);
		Services.getDataFromList(Locators.MENU_LIST2, "Laptops");
		Services.applyImplicitWait();
		Services.getProcessorCheckbox();
		Services.selectCheckBox(Services.cpuTypeCheckbox);
		Services.applyImplicitWait();
		Services.getRAMCheckBox();
		Services.selectCheckBox(Services.memorySizeCheckBox);
		Services.applyImplicitWait();
		Services.displaySizeCheckBox1();
		Services.selectCheckBox(Services.displaySizeCheckBox1);
		Services.applyImplicitWait();
		Services.displaySizeCheckBox2();
		Services.selectCheckBox(Services.displaySizeCheckBox2);
		Services.applyWait(Locators.priceDropdown);
		
		Services.clickElement(Locators.priceDropdown);
		Services.getDataFromList(Locators.priceDropdownList, "Price: Low to High");
		Services.applyImplicitWait();

		// I presume that dropdown of price sorting in amazon is working as //
		// expected, hence I have not written logic to get the lowest value of
		// pricing

		System.out.println("$$$$$$$$$" + "   Lowest Price of Laptop is mentioned below   " + "$$$$$$$$$");
		System.out.println(Services.getText(Locators.lowestPrice));

		Services.applyWait(Locators.lowestPrice);

		Services.clickElement(Locators.lowestPrice);
		Services.handleWindow(Locators.buyNowBttn);
		Services.closeBrowser();

	}

	@Test(priority = 2)

	void verifyLowestPriceWithUserCredential() throws InterruptedException {

		Services.initializeDriver();
		Services.login(true);
		Services.applyImplicitWait();
		Services.clickElement(Locators.MENU_ICON);
		Services.applyImplicitWait();

		Services.getDataFromList(Locators.MENU_LIST1, "Mobiles, Computer");
		Services.applyWait(Locators.MENU_LIST2);
		Services.getDataFromList(Locators.MENU_LIST2, "Laptops");

		Services.applyImplicitWait();
		Services.getProcessorCheckbox();
		Services.selectCheckBox(Services.cpuTypeCheckbox);
		Services.applyImplicitWait();
		Services.getRAMCheckBox();
		Services.selectCheckBox(Services.memorySizeCheckBox);
		Services.applyImplicitWait();
		Services.displaySizeCheckBox1();
		Services.selectCheckBox(Services.displaySizeCheckBox1);
		Services.applyImplicitWait();
		Services.displaySizeCheckBox2();
		Services.selectCheckBox(Services.displaySizeCheckBox2);
		Services.applyWait(Locators.priceDropdown);
		Services.clickElement(Locators.priceDropdown);
		Services.getDataFromList(Locators.priceDropdownList, "Price: Low to High");
		Services.applyImplicitWait();

		// I presume that dropdown of price sorting in amazon is working as 
		// expected, hence I have not written logic to get the lowest value of
		// pricing

		System.out.println("$$$$$$$$$" + "  Lowest Price of Laptop is mentioned below  " + "$$$$$$$$$");
		System.out.println(Services.getText(Locators.lowestPrice));
		Services.applyImplicitWait();

		Services.applyWait(Locators.lowestPrice);
		Services.clickElement(Locators.lowestPrice);
		Services.handleWindow(Locators.buyNowBttn);
		Services.closeBrowser();

	}

}