package steam.helpers;

import a1qa.selenium.browser.BrowserManager;
import a1qa.selenium.waitings.SmartWait;

import java.io.File;
import java.nio.file.Paths;

public class FileHelpers {
    private static final String DOWNLOAD_DIR_DEFAULT = BrowserManager.getBrowser().getDownloadDirectory();
    private static final String DOWNLOAD_DIR = System.getProperty("downloadsDir", DOWNLOAD_DIR_DEFAULT);

    public static boolean waitForFileIsDownloaded(String fileName) {
        File file = new File(Paths.get(DOWNLOAD_DIR, fileName).toString());
        return SmartWait.waitForTrue(temp -> file.exists(), 60);
    }

    public static long getDownloadedFileSize(String fileName) {
        File file = new File(Paths.get(DOWNLOAD_DIR, fileName).toString());
        return file.getTotalSpace();
    }
}
