package BaseTest;

import Base.BasePage;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private String url;

    @BeforeClass
    public void browserStart(){
        String env = System.getProperty("env");
        if (env == null){
           env = "qa";
        }

        if (env.contains("prod")){
            url = Constants.PROD_ENV;
        } else if (env.contains("dev")) {
            url = Constants.DEV_ENV;
        }else
           url = Constants.QA_ENV;
        BasePage.setUpBrowser(url, env);
    }

    @AfterClass
    public void tearDown(){
        BasePage.browserTearDown();
    }
}
