package steam.steps;

import org.testng.Assert;
import steam.helpers.FileHelpers;
import steam.pages.AboutPage;

public class AboutPageSteps {

    public static void clickInstallSteam() {
        AboutPage aboutPage = new AboutPage();
        Assert.assertTrue(aboutPage.isFormDisplayed(), "About page is displayed");
        aboutPage.clickInstallButton();
    }

    public static void assertSteamIsDownloaded(String setupFile) {
        Assert.assertTrue(FileHelpers.waitForFileIsDownloaded(setupFile), "Steam setup file is downloaded");
    }

    public static void assertSteamSize(String setupFile) {
        Assert.assertNotEquals(FileHelpers.getDownloadedFileSize(setupFile), 0, "File size is not equal to 0");
    }
}
