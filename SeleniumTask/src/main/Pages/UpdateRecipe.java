import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UpdateRecipe {
    private WebDriver driver;
    private By goTo = By.linkText("Spaghetti");
    private By editBttn= By.id("btn-edit1");
    private By recipe= By.xpath("//input[@type='text']");
    private By ingredients= By.xpath("//textarea[@type='textarea']");
    private By editRecipe= By.id("addButton");
    private By updatedRecipe = By.linkText("indomi");

    public UpdateRecipe(WebDriver driver)
    {
        this.driver = driver;
    }

    public void update(String recipeName , String ingredient)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame("CodePen");
        driver.findElement(goTo).click();
        driver.findElement(editBttn).click();
        driver.findElement(recipe).clear();
        driver.findElement(recipe).sendKeys(recipeName);
        driver.findElement(ingredients).clear();
        driver.findElement(ingredients).sendKeys(ingredient);
        driver.findElement(editRecipe).click();
        Assert.assertEquals(recipeName,"indomi");
        Assert.assertEquals(ingredient,"macaroni & spices");
        driver.findElement(updatedRecipe).click();



    }



}
