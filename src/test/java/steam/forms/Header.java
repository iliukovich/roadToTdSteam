package steam.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class Header extends Form {

    public Header() {
        super(
                By.id("global_header"),
                "Header"
        );
    }

    private IButton installSteamButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'installsteam')]"), "install steam button");

    public void clickInstallSteam() {
        installSteamButton.clickAndWait();
    }
}
