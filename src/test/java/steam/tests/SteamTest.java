package steam.tests;

import framework.base.BaseTest;
import helpers.TestInfo;
import org.testng.annotations.Test;
import steam.steps.ActionPageSteps;
import steam.steps.MainPageSteps;

@TestInfo(id = 1)
public class SteamTest extends BaseTest {

    @Override
    @Test
    public void runTest() {
        int stepCount = 1;
        logStep(stepCount, "Select Action Genre");
        MainPageSteps.selectGenreFromMainMenu();

        logStep(++stepCount, "Check that Action page is displayed");
        ActionPageSteps.assertActionPageIsDisplayed();
    }
}
