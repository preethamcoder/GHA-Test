package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "C:/Users/sthelluri1/Downloads/chromedriver_win32/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the article page
            driver.get("URL_OF_THE_ARTICLE");

            // Check if the URL contains "cnn.com"
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("cnn.com")) {
                System.out.println("The article is from CNN.");
            } else {
                System.out.println("The article is not from CNN.");
            }

            // Additional check by verifying specific CNN elements (optional)
            List<WebElement> cnnElements = driver.findElements(By.cssSelector("SPECIFIC_CSS_SELECTOR"));
            if (!cnnElements.isEmpty()) {
                System.out.println("The article is confirmed to be from CNN based on page elements.");
            } else {
                System.out.println("The article is not from CNN based on page elements.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}