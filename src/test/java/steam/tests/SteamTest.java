package steam.tests;

import framework.base.BaseTest;
import helpers.TestInfo;
import org.testng.annotations.Test;
import steam.steps.*;

@TestInfo(id = 1)
public class SteamTest extends BaseTest {

    @Override
    @Test
    public void runTest() {
        int stepCount = 1;
        logger.step(stepCount, "Select Action Genre");
        MainPageSteps.selectGenreFromMainMenu();

        logger.step(++stepCount, "Check that Action page is displayed");
        ActionPageSteps.assertActionPageIsDisplayed();
    }
}
