package com.hackathon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.get("http://localhost:3000");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod(enabled = false)
    public void tierDown(){
        wd.quit();
    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Test start " + m.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: test method " + result.getMethod().getMethodName());
        }
    }
}
