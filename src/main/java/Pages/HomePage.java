package Pages;

import Base.BasePage;
import org.openqa.selenium.By;

public class HomePage {

    private static final By homeIcon = By.xpath("//*[@class='app_logo']");
    private static String productListName = "//div[@id='inventory_container']//div[text()='NAME']/..";

    public static void clickHomeIcon(){
        BasePage.click(homeIcon);
    }

    public static boolean isHomeIconVisible(){
        return BasePage.isElementVisible(homeIcon);
    }

    public static void selectItemByName(String productName){
        BasePage.click(By.xpath(productListName.replace("NAME",productName)));
    }
}
