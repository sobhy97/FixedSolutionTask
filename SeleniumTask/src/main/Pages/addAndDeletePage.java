import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class addAndDeletePage {

    private WebDriver driver;
    private By add= By.xpath("//button[@class='btn btn-lg btn-primary']");
    private By recipe= By.xpath("//input[@type='text']");
    private By ingredients= By.xpath("//textarea[@type='textarea']");
    private By addBttn= By.id("addButton");
    private By addedRecipe = By.linkText("Sea Food");
    private By deleteBttn= By.id("btn-del3");
    private By dd = By.linkText("Spaghetti");
    String allList;



    public addAndDeletePage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void addAndDelete()
    {
        addRecipe("Sea Food","shrimp");
        deleteRecipe();
    }

    public void addRecipe(String recipeName , String ingredient) {

        driver.switchTo().frame("CodePen");
        driver.findElement(add).click();
        driver.findElement(recipe).sendKeys(recipeName);
        driver.findElement(ingredients).sendKeys(ingredient);
        driver.findElement(addBttn).click();
        Assert.assertEquals(recipeName,"Sea Food");
        Assert.assertEquals(ingredient,"shrimp");

        List<WebElement> webElement = driver.findElements(By.xpath("//div[@role='tablist']"));

        for (WebElement obj : webElement) {
            allList = obj.getText();
            System.out.println(allList);
        }

    }


    public void deleteRecipe() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(addedRecipe).click();
        driver.findElement(deleteBttn).click();
        List<WebElement> webElement = driver.findElements(By.xpath("//div[@role='tablist']"));

        for (WebElement obj : webElement)
        {
            String allRecipes = obj.getText();
            System.out.println(allRecipes);
            Assert.assertNotEquals(allRecipes,allList);

        }

    }


}
