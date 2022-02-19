import org.testng.annotations.Test;

public class UpdateRecipeTestCase extends Testbase {

    @Test
    public void clickOnEditBttn() throws Exception {
        updateRecipe.update("indomi","macaroni & spices");
    }
}
