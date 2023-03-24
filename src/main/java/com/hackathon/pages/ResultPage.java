package com.hackathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ResultPage extends PageBase{
    public ResultPage(WebDriver wd) {
        super(wd);

    }


    @FindBy(css = "h4:nth-child(1)")
    WebElement index;
    public String getIndexTitel() {
        return index.getText();
    }

}
