package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinition {
	Utility fileUtil = new Utility();
	String path = System.getProperty("user.dir");
	String testtype = System.getenv("testtype").toLowerCase();
	static WebDriver driver;
	String browser;
	
   @Before
	public void initializeTest() throws IOException {
		// Code to setup initial configurations
		
		System.out.println("Starting Test");
		if(testtype.equalsIgnoreCase("ui")) {
			browser = System.getenv("browser").toLowerCase();
		}
	}

	@Given("^user logs into application$")
	public void loginApplication() throws IOException {
		
	    String excelPath = path + fileUtil.getProperty("datafile");
		String appURL = fileUtil.readExcel(excelPath);
		
		System.out.println("Application URL : "+ appURL);
		
		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", path + fileUtil.getProperty("chromedriverfile"));
		System.out.println(path + fileUtil.getProperty("chromedriverfile"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(driver.getTitle(),"The Internet");
		
	}
	
	@Given("^user logs into application failure$")
	public void loginApplicationFailure() throws IOException {
	    String excelPath = path + fileUtil.getProperty("datafile");
		String appURL = fileUtil.readExcel(excelPath);
		
		System.out.println("Application URL : "+ appURL);
		
		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", path + fileUtil.getProperty("chromedriverfile"));
		System.out.println(path + fileUtil.getProperty("chromedriverfile"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		

		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(driver.getTitle(),"The Internet1");
		
		
	}


	@Then("^click on (.*) link$")
	public void clickLink(String linkName) {
		driver.findElement(By.xpath("//a[text()='" + linkName + "']")).click();
	}

	@Then("^click on (.*) button$")
	public void clickButton(String buttonName) {
		driver.findElement(By.xpath("//*[@id='" + buttonName + "']/button")).click();
	}

	@Then("^click on button$")
	public void clickbuttonJS() {
		driver.findElement(By.xpath("//*[@class='example']//li[2]/button")).click();
	}

	@Then("^cancel the alert$")
	public void cancelAlert() throws InterruptedException {
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);
		promptAlert.dismiss();
		

	}

	@Then("^validate the canceled message$")
	public void validateCancelMsg() throws InterruptedException {
		String cancelMsg = driver.findElement(By.xpath("//*[@id='result']")).getText();

		assertEquals(cancelMsg,"You clicked: Cancel");
		
	}

	@Then("^validate the progress bar & verify final message$")
	public void validateProgressBar() {
		long timeoutInSeconds = 30;
		new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		System.out.println("Loading done");
		String finalMsg = driver.findElement(By.xpath("//*[@id='finish']")).getText();

		assertEquals(finalMsg, "Hello World!");

	}

	@Then("^Log the URL of new tab and close it$")
	public void geturlAndClose() {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("URL of new tab: " + driver.getCurrentUrl());
		// switch to parent window
		driver.switchTo().window(newTb.get(0));
	}

	@Then("^Log the title of the current page$")
	public void getURL() {
		System.out.println("URL of current page : " + driver.getCurrentUrl());
		
		assertEquals(driver.getTitle(),"The Internet");
	}

	@Then("^Drag box A and drop it into B and validate success$")
	public void DragDrop() throws InterruptedException {

		WebElement from = driver.findElement(By.xpath("//*[@id='column-a']"));
		WebElement to = driver.findElement(By.xpath("//*[@id='column-b']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", from, to);
		
			Thread.sleep(1500);
		
		String textTo = to.getText();
		if (textTo.equals("A")) {
			System.out.println("PASS: Box is dropped to target as expected");
		} else {
			System.out.println("FAIL: Box couldn't be dropped to target as expected");
		}
		assertEquals(textTo,"A");
		
	}

	@Then("^clear text and enter (.*) and apply bold style to text$$")
	public void clearEnterText(String text) throws InterruptedException {

		WebElement iframeMsg = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframeMsg);

		WebElement body = driver.findElement(By.cssSelector("body"));
		System.out.println(body.getText());

		body.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		body.sendKeys(text);
		
		Thread.sleep(1500);
		body.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		body.sendKeys(Keys.chord(Keys.CONTROL, "b"));
		body.click();

	}

	@Then("^Take Screenshot (.*)$")
	public void screenshot(String fileName) throws IOException {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(path + fileUtil.getProperty("screenshotPath") + fileName + ".png");

		// Copy file at destination

		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^retrieve credentials and store to file$")
	public void retrieveAndStore() throws IOException {
		String username = driver.findElement(By.xpath("//*[@class=\"subheader\"]/em[1]")).getText();
		String password = driver.findElement(By.xpath("//*[@class=\"subheader\"]/em[2]")).getText();

		fileUtil.writeJson(path + fileUtil.getProperty("jsonfilepath"),username, password);
		
	}

	@Then("^read json and login$")
	public void returnAndLogin() throws IOException {

			String username = fileUtil.readJson(path + fileUtil.getProperty("jsonfilepath"), "username");
			String password = fileUtil.readJson(path + fileUtil.getProperty("jsonfilepath"), "password");
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id='login']/button")).click();

	}

	@Then("^validate login success and logout$")
	public void validateLoginSuccess() throws IOException {

		driver.findElement(By.xpath("//*[@class='button secondary radius']")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='content']//h2")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='content']//h4")).isDisplayed();
		driver.findElement(By.xpath("//*[@class='button secondary radius']//i")).click();

	}

	@Then("^validate login failure$")
	public void validateFailure() throws IOException {


			String username = fileUtil.readJson(path + fileUtil.getProperty("jsonfilepath"), "username");
			String password = fileUtil.readJson(path + fileUtil.getProperty("jsonfilepath"), "password");
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password + "1");
			driver.findElement(By.xpath("//*[@id='login']/button")).click();

			String errorMsg = driver.findElement(By.xpath("//*[@id='flash']")).getText();
			errorMsg = errorMsg.split("\n")[0];

			assertTrue(errorMsg.equals("Your password is invalid!"));

	}

	@After(order=0)
	public void quit(){
		if(testtype.equalsIgnoreCase("ui")) {
		driver.quit();
		}
	}
	
	@After(order=1)
	public void takeScreenshotonFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	         scenario.attach(src, "image/png", "screenshot");;
	        }
	}
	
}
