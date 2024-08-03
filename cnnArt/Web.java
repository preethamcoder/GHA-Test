package sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.lang.*;

public class Web {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/sthelluri1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "C:/Users/sthelluri1/Downloads/chromedriver_win32/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the article page
//            driver.get("https://www.cnn.com/2024/08/02/politics/kamala-harris-democratic-nomination-election/index.html");
        	driver.get("https://www.gmail.com/");
            Thread.sleep(3000);
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            /html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]
//            WebElement articleContent = (WebElement) ExpectedConditions.presenceOfElementLocated(By.cssSelector("article"));
            WebElement articleContent = driver.findElement(By.cssSelector("article"));
            String articleText = articleContent.getText();
            System.out.println(articleText);
            if (articleText.contains("Ukraine")) {
                System.out.println("The article is about Ukraine.");
            } else {
                System.out.println("The article is not about Ukraine.");
            }
//            // Check if the URL contains "cnn.com"
//            String currentUrl = driver.getCurrentUrl();
//            if (currentUrl.contains("cnn.com")) {
//                System.out.println("The article is from CNN.");
//            } else {
//                System.out.println("The article is not from CNN.");
//            }
//            Thread.sleep(200000);
//            // Additional check by verifying specific CNN elements (optional)
//            List<WebElement> cnnElements = driver.findElements(By.cssSelector("SPECIFIC_CSS_SELECTOR"));
//            if (!cnnElements.isEmpty()) {
//                System.out.println("The article is confirmed to be from CNN based on page elements.");
//            } else {
//                System.out.println("The article is not from CNN based on page elements.");
//            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}
}
