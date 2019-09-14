package steam.pages;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(id = "about_header", pageName = "About page")
public class AboutPage extends BaseForm {

    private IButton installButton = getElementFactory().getButton(By.xpath("//div[contains(@id, 'header')]//a[contains(@class, 'install_steam')]"), "install steam button");

    public void clickInstallButton() {
        installButton.clickAndWait();
    }
}
