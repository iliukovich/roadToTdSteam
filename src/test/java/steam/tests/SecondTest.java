package steam.tests;

import framework.base.BaseTest;
import helpers.TestInfo;
import org.testng.annotations.Test;
import steam.steps.AboutPageSteps;
import steam.steps.HeaderSteps;

@TestInfo(id = 2)
public class SecondTest extends BaseTest {

    private static final String STEAM_SETUP_FILE = "SteamSetup.exe";

    @Override
    @Test
    public void runTest() {
        int stepCount = 1;
        logger.step(++stepCount, "Click \"Install\" button in Header");
        HeaderSteps.clickInstallSteamButton();

        logger.step(++stepCount, "Download \"SteamSetup.exe\"");
        AboutPageSteps.clickInstallSteam();

        logger.step(++stepCount, "Check that \"SteamSetup.exe\" is downloaded");
        AboutPageSteps.assertSteamIsDownloaded(STEAM_SETUP_FILE);

        logger.step(++stepCount, "Check that size of downloaded \"SteamSetup.exe\" and expected size are equal");
        AboutPageSteps.assertSteamSize(STEAM_SETUP_FILE);
    }
}
