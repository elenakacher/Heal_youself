package com.hackathon.tests;

import com.hackathon.TestBase;
import com.hackathon.pages.ResultPage;
import com.hackathon.pages.SfFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SfFormTests extends TestBase {

    @Test
    public void fillInQuestionnaire(){
        new SfFormPage(wd).clickObStartBtn().chooseBodyPart().answerFormSf()
                .fillInPersonalData("Yoga", "Yoga is the best thing that ever happened to me! My back feels like it is been reborn",
                        "160", "80", "67");
        Assert.assertTrue(new ResultPage(wd).getIndexTitel().contains("Your health score:"));
    }

}
