package screens;

import org.openqa.selenium.WebElement;

import commonutilities.AppDriver;
import commonutilities.Library;

public class Dashboard extends AppDriver{
	float finalShipingPrice;
	public Dashboard() {
		super();
	}
	public void createAccount(){
		library.clickOnAnyElement("//a[normalize-space(text())='Sign in']", "xpath", "click");
		library.send_To_TextBox("email_create", "id", "lal12.chaudhary@gmail.com");
		library.clickOnAnyElement("//*[@id='SubmitCreate']", "xpath", "click");
		library.clickOnAnyElement("//*[@type='radio']", "xpath", "click");
		library.send_To_TextBox("customer_firstname", "id", "lalsahab");
		library.send_To_TextBox("customer_lastname", "id", "chaudhary");
		library.send_To_TextBox("//input[@type='password']", "xpath", "Tiger@123");
		library.singleDropDownSelect("days", "id", "5", "value");
		library.singleDropDownSelect("months", "id", "4", "value");
		library.singleDropDownSelect("years", "id", "1984", "value");
		library.send_To_TextBox("address1", "id", "Noida");
		library.send_To_TextBox("city", "id", "Noida");
		library.singleDropDownSelect("id_country", "id", "United States", "text");
		library.singleDropDownSelect("id_state", "id", "California", "text");
		library.send_To_TextBox("postcode", "id", "11111");
		library.send_To_TextBox("phone_mobile", "id", "9015884053");
		library.send_To_TextBox("alias", "id", "Sector 47");
		library.clickOnAnyElement("//*[text()='Register']", "xpath", "click");
	}
	public void loginToApplication(){
		library.clickOnAnyElement("//a[normalize-space(text())='Sign in']", "xpath", "click");
		library.send_To_TextBox("email", "id", "lal12.chaudhary@gmail.com");
		library.send_To_TextBox("passwd", "id", "Tiger@123");
		library.clickOnAnyElement("//*[@id='SubmitLogin']/span", "xpath", "click");
	}
	public void checkOutProcess() throws Exception{
		library.clickOnAnyElement("//a[@title='Women']", "xpath", "click");
		library.clickOnAnyElement("//div[@class='product-image-container']//img[1]", "xpath", "click");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		String priceDisplay = library.get_WebElement_Object("//span[@id='our_price_display']", "xpath").getText();
		String price=priceDisplay.substring(1);
		float costOfSingleItem = Float.valueOf(price).floatValue();
		System.out.println(costOfSingleItem);
		String quantity = library.get_WebElement_Object("//input[@id='quantity_wanted']", "xpath").getAttribute("value");
		int totalQuantity = Integer.parseInt(quantity);
		if(totalQuantity==1){
			library.clickOnAnyElement("//*[@class='icon-plus']", "xpath", "click");
		}
		library.clickOnAnyElement("//*[@id='add_to_cart']//span[text()='Add to cart']", "xpath", "click");
		String totalPrice = library.get_WebElement_Object("//span[@class='ajax_block_products_total']", "xpath").getText();
		totalPrice=totalPrice.substring(1);
		Float finalPrice = Float.valueOf(totalPrice).floatValue();
		if(finalPrice==(costOfSingleItem*2)){
			System.out.println("Price Maching "+finalPrice);
		}
		library.clickOnAnyElement("//*[normalize-space(text())='Proceed to checkout']", "xpath", "click");
		library.clickOnAnyElement("//*[text()='Proceed to checkout']", "xpath", "click");
		library.clickOnAnyElement("//*[text()='Proceed to checkout']", "xpath", "click");
		library.clickOnAnyElement("//input[@type='checkbox']", "xpath", "click");
		library.clickOnAnyElement("(//*[normalize-space(text())='Proceed to checkout'])[2]", "xpath", "click");
		//Matching price
		String shipingPrice = library.get_WebElement_Object("//span[@id='total_price']", "xpath").getText();
		shipingPrice=shipingPrice.substring(1);
		finalShipingPrice = Float.valueOf(shipingPrice).floatValue();
		float shipingcharge=2.00f;
		if(finalShipingPrice==(finalPrice+shipingcharge)){
			System.out.println("Shiping price match");
		}
		library.clickOnAnyElement("//a[@title='Pay by bank wire']", "xpath", "click");
		library.clickOnAnyElement("//*[text()='I confirm my order']", "xpath", "click");
	}
	public void checkHistory(){
		library.clickOnAnyElement("//a[@title='View my customer account']", "xpath", "click");
		library.clickOnAnyElement("//span[text()='Order history and details']", "xpath", "click");
		String value = library.get_WebElement_Object("//*[@class='history_price']", "xpath").getAttribute("data-value");
		float TotalPrice = Float.valueOf(value).floatValue();
		if(TotalPrice==finalShipingPrice){
			System.out.println("Order History Verified");
		}
		
	}
	
	
}
