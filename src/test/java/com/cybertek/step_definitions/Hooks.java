package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before(order = 2)
    public void setUpScenario(){
        System.out.println("-----> Before annotation: Setting up browser");
    }

    @Before(value = "@db", order = 1)
    public void setUpDatabaseConnection(){
        System.out.println("--------> BEFORE ANNOTATION: DB CONNECTION CREATED <------");
    }

    @After(order = 3)
    public void tearDownScenario(Scenario scenario){
       // System.out.println("-----> After annotation: Closing browser");

    /*  THIS IS JUST FOR US TO KNOW THAT SCENARIO.getSomething does exist:
     // scenario.getName();// after this print soutv and press tab key you will get the next line
        System.out.println("scenario.getName() = " + scenario.getName());

       // scenario.getSourceTagNames();
        System.out.println("scenario = " + scenario.getSourceTagNames());

        //scenario.isFailed();
        System.out.println("scenario.isFailed() = " + scenario.isFailed());

     */
        //  Screenshot
        //#1. we need to take a screen shot using selenium -->
        //getScreenshotAs: to be able to use this method we have to cast our driver type to TakeScreenshot

       //#2. we are going to attach it into our report: using attach method
        // attach method accept 3 argument. #1 Screenshot itself, #2 image type #3 current scenario name

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


    }

    @After(value = "@db" , order = 4)
    public void tearDownDatabaseConnection(){
        System.out.println("--------> AFTER ANNOTATION: DB CONNECTION CLOSED <------");
    }

    @BeforeStep
    public void setUpStep(){
        System.out.println("=====> BEFORESTEP: TAKING SCREENSHOT <=====");
    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("=====> AFTERSTEP: TAKING SCREENSHOT <=====");
    }


}
