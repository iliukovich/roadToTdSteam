package steam.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AboutPage extends Form {

    private IButton installButton = getElementFactory().getButton(By.xpath("//div[contains(@id, 'header')]//a[contains(@class, 'install_steam')]"), "install steam button");

    public AboutPage() {
        super(
                By.id("about_header"),
                "About page"
        );
    }

    public void clickInstallButton() {
        installButton.clickAndWait();
    }
}
