package steam.forms;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(id = "global_header", pageName = "Header")
public class Header extends BaseForm {

    private IButton installSteamButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'installsteam')]"), "install steam button");

    public void clickInstallSteam() {
        installSteamButton.clickAndWait();
    }
}
