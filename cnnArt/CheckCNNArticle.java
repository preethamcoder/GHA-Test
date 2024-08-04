package sel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CheckCNNArticle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/sthelluri1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/sthelluri1/eclipse-workspace/Real_Selenium/src/sel/res.html");
//		driver.get("https://www.cnn.com");
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
//		WebElement logo = driver.findElement(By.xpath("/html/body/header/div/nav/div/div/div[1]/div[1]/div/a"));
//		String color = logo.getCssValue("color");
//		if(color.equals("rgba(0, 0, 238, 1)")) {
//			System.out.println("Correct color has loaded: "+color);
//		}else {
//			System.out.println("Wrong color on the logo");
//		}
		try {
////			Thread.sleep(100000000);
//			WebElement searchbar = driver.findElement(By.xpath("/html/body/header/div/nav/div/div/div[1]/div[2]/button"));
//			Thread.sleep(150);
//			searchbar.click();
//			WebElement search = driver.findElement(By.xpath("/html/body/header/div/nav/div/div/div[2]/div/div[1]/form/input"));
//			search.click();
//			Thread.sleep(1000);
//			search.sendKeys("palestine");
//			search.sendKeys(Keys.ENTER);
//			Thread.sleep(20000);
			List<WebElement> dd = driver.findElements(By.tagName("p"));
			for(WebElement we: dd) {
				System.out.println(we.getText());
			}
//			Select select = new Select(dd);
			Thread.sleep(2000);
//			select.selectByVisibleText("SWD");
//			Thread.sleep(20000);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			driver.quit();
		}
//		System.out.println(color);
//		List<WebElement> cnnLogos = driver.findElements(By.className("a"));
//		for (WebElement w: cnnLogos) {
//			System.out.println(w);
//		}
//		System.out.println("Nesghig");
//		String color = cnnLogo.getCssValue("color");
//		if (color.equals("rgb(255, 0, 0)")) {
//			System.out.println("CNN Logo is RED");
//		}else {
//			System.out.println("Fake logo detected");
//		}
//		driver.findElement(By.xpath("/html/body/header/div/nav/div/div/div[1]/div[1]/button[1]")).click();
		
	}
}
