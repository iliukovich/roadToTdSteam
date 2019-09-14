package steam.steps;

import aqa.assertion.AqaAssert;
import steam.helpers.FileHelpers;
import steam.pages.AboutPage;

public class AboutPageSteps {

    public static void clickInstallSteam() {
        AboutPage aboutPage = new AboutPage();
        AqaAssert.isTrue(aboutPage.isFormDisplayed(), "About page is displayed");
        aboutPage.clickInstallButton();
    }

    public static void assertSteamIsDownloaded(String setupFile) {
        AqaAssert.isTrue(FileHelpers.waitForFileIsDownloaded(setupFile), "Steam setup file is downloaded");
    }

    public static void assertSteamSize(String setupFile) {
        AqaAssert.areNotEqual(FileHelpers.getDownloadedFileSize(setupFile), 0, "File size is not equal to 0");
    }
}
