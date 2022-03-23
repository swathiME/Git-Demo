package UnDosTres.UnDosTresTest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sampletest {

	public String baseURL=" http://sanbox.undostres.com.mx";
	String driverpath="C:\\\\Users\\\\SWATHI\\\\Driver\\\\cdriver\\\\Chromedriver\\\\chromedriver.exe";
	public WebDriver driver;

	
	@BeforeTest
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		driver.get(baseURL);
		System.out.println("changed it");
	}
	
	@Test
	public void ApplucationOperations()
	{
		
		System.out.println("changed it twice");
		String expectedurl="https://sanbox.undostres.com.mx/payment.php";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("//div[@class='user-interact']/div[2]/ul/li[1]/div/div/input[@name='operator']")).click();
		
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='suggestion']/ul/li"));
		for(WebElement element:ele)
		{
			if(element.getText().equalsIgnoreCase("Telcel"))
			{
				element.click();
			break;
			}
		}
		driver.findElement(By.xpath("//div[@class='user-interact']/div[2]/ul/li[2]/div/div/input[@name='mobile']")).sendKeys("8465433546");
		driver.findElement(By.xpath("//div[@class='user-interact']/div[2]/ul/li[3]/div/div/input[@name='amount']")).click();
		List<WebElement> rates=driver.findElements(By.xpath("//ul[@class='category-list  cat1']/li/a/div/b"));
		for(WebElement rate:rates)
		{
			if(rate.getText().equalsIgnoreCase("$10"))
			{
				rate.click();
			break;
			}
		}
		driver.findElement(By.xpath("//div[@class='proceed']/div[@class='next']/button[@class='button buttonRecharge']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),expectedurl);
	}



@Test
public void paymentcheck()
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	driver.findElement(By.xpath("//div[@id='container_all_pay_options']/div/div/div[2]")).click();
	//driver.findElement(By.xpath(" //span[@id='cardGly']")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Usar nueva tarjeta')]")).click();
	WebElement carnnum=driver.findElement(By.xpath("//form[@id='payment-form']/div[2]/div/div/div/input"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='4111111111111111'", carnnum);
	WebElement mon=driver.findElement(By.xpath("//input[@placeholder='Mes']"));
js.executeScript("arguments[0].value='11'", mon);
WebElement date=driver.findElement(By.xpath("//input[@placeholder='Año']"));
js.executeScript("arguments[0].value='25'", date);
WebElement cvv=driver.findElement(By.xpath("//input[@placeholder='CVV']"));
js.executeScript("arguments[0].value='111'", cvv);
WebElement email=driver.findElement(By.xpath("//input[@class='form-control email preventChromeAutofill']"));
js.executeScript("arguments[0].value='test@test.com.'", email);
System.out.println("cvv is"+cvv.getText());
//WebElement pay=driver.findElement(By.xpath("//button[@id='paylimit']"));
//js.executeScript("arguments[0].click();", pay);
//System.out.println(pay.getText());


	


}
}

