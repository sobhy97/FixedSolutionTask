import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Testbase {

    private WebDriver driver;
    private String url = "https://codepen.io/SedatUygur/pen/jWgJdv";
    protected addAndDeletePage addAndDeletePage;
    protected UpdateRecipe updateRecipe;

    @BeforeClass
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(725,625));
        addAndDeletePage = new addAndDeletePage(driver);
        updateRecipe = new UpdateRecipe(driver);

    }

	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
}
