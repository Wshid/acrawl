package com.wshid.test;

import static com.wshid.acrawlConstants.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author wshid
 * @project acrawl
 * @date 2018. 4. 5. PM 1:46
 */
public class testMain {

    @Autowired
    private static testComponent testcomponent;


    // private static final Logger logger = LogManager.getLogger(testMain.class);

    public static void main(String[] args) throws Exception {
        System.out.println("main Method in");
        //System.out.println(testcomponent.getName() + "NAME ");

        //logger.info("Hello Phantom!");
        phantomjstest();


    }

    /*
    ### https://examples.javacodegeeks.com/enterprise-java/selenium/selenium-headless-browser-testing/ 해당 내용에 맞게 작업하기
     */

    public void chrometest() throws Exception {
        URL local = new URL("http://localhost:9515");
        WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());
        // open the browser and go to JavaTutorial Network Website
        driver.get("http://javatutorial.net");
        // find the search button on the page
        WebElement searchButton = driver.findElement(By
                .className("search-submit"));
        // create an action handler
        Actions actions = new Actions(driver);
        // use the action handler to move the cursor to given element
        actions.moveToElement(searchButton).perform();
        // wait until the search field is presented on the webpage and create an
        // element
        WebElement searchField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("s")));
        // puts the text "java" into the search field
        searchField.sendKeys("java");
        // submit the search (submit the form)
        searchField.submit();
        // wait 5 seconds and close the browser
        Thread.sleep(5000);
        driver.quit();
    }

    /**
     * Using phantomjs and selenium
     */
    public static void phantomjstest() {
        File file = new File(phantomjsPath);
        System.setProperty(phantomProperty, file.getAbsolutePath());

        WebDriver driver = new PhantomJSDriver();
        //driver.get("http://www.google.com");
        driver.get("http://finance.naver.com/sise/lastsearch2.nhn");

        /**
         * 단일 내용을 가져오는 구문
         */
        //WebElement webElement = driver.findElement(By.name("q"));
        //WebElement webElement = driver.findElement(By.className("number"));
        //System.out.println(webElement.getText());

        List<WebElement> webElementList = driver.findElements(By.className("number"));
        for(WebElement e : webElementList){
            System.out.println(e.getText()); // ### 해당 내용이 출력되기는 하나 hierarchy한 클래스를 참조할때 해당 내용 참조 방법에 대해 익혀야 할 듯 함
        }
        //webElement.sendKeys("Java Code Geeks");
        //webElement.submit();

        System.out.println("Title of the page now is " + driver.getTitle());
        driver.quit();


    }
}
