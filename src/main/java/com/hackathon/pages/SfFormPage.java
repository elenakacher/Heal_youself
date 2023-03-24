package com.hackathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SfFormPage extends PageBase {
    public SfFormPage(WebDriver wd) {
        super(wd);
    }
     @FindBy(css = ".StartPage_start_button__fAC0k")
    WebElement startBtn;

    public SfFormPage clickObStartBtn() {
        click(startBtn);
        return this;
    }

    @FindBy(xpath = "//button[@value = 'lower_back']")
    WebElement bodyPartMarker;

    @FindBy(css = ".Button_button_block__UbMJT")
    WebElement nextBtn1;
    public SfFormPage chooseBodyPart() {
        click(bodyPartMarker);
        pause(500);
        click(nextBtn1);
        return this;
    }
    @FindBy(xpath = "//*[@class='QuestionItem_form__O386d'] [1] /input[@class = 'QuestionItem_radio__7Zi6e']")
    WebElement antwort1;

    @FindBy(xpath = "//*[@class='QuestionItem_form__O386d'] [2] /input[@class = 'QuestionItem_radio__7Zi6e']")
    WebElement antwort2;
    @FindBy(css = ".QuestionsPage_arrows__dqui6 :nth-child(2)")
    WebElement nextBtn2;
    public SfFormPage answerFormSf() {
        for (int i = 0; i < 36; i++) {
            if (i % 2 ==0){
                click(antwort1);
                pause(300);
            }
            else {
                click(antwort2);
                pause(300);
            }
            click(nextBtn2);
        }
        return this;
    }

    @FindBy(xpath = "//input[@placeholder = 'cm']")
    WebElement heightField;
    @FindBy(xpath = "//input[@placeholder = 'kg']")
    WebElement weightField;
    @FindBy(xpath = "//input[@name = 'age']")
    WebElement ageField;
    @FindBy(xpath = "//select[@name = 'therapy']")
    WebElement therapyField;
    @FindBy(xpath = "//textarea[@name = 'story']")
    WebElement storyField;
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement publishStoryBtn;
    public SfFormPage fillInPersonalData(String text, String story, String height, String weight, String age) {
        type(heightField, height);
        type(weightField, weight);
        type(ageField, age);
        Select select = new Select(therapyField);
        select.selectByVisibleText(text);
        type(storyField, story);
        pause(200);
        click(publishStoryBtn);
        return this;
    }

}
