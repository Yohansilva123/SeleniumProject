package Pages;

import Base.BasePage;
import org.openqa.selenium.By;

public class HomePage {

    private static By homeIcon = By.xpath("//*[@class='app_logo']");

    public static void clickHomeIcon(){
        BasePage.click(homeIcon);
    }

    public static boolean isHomeIconVisible(){
        return BasePage.isElementVisible(homeIcon);
    }
}
