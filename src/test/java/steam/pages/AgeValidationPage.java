package steam.pages;

import a1qa.selenium.elements.interfaces.IButton;
import a1qa.selenium.elements.interfaces.IComboBox;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;

@PageInfo(xpath = "//div[contains(@id, 'app_agegate')]", pageName = "Age validation page")
public class AgeValidationPage extends BaseForm {

    private IComboBox birthYearComboBox = getElementFactory().getComboBox(By.id("ageYear"), "birth year");
    private IButton viewProductPageButton = getElementFactory().getButton(By.xpath("//div[contains(@class, 'agegate')]//a[@onclick]"), "view product page");

    public void validateAge(String birthYear) {
        if(birthYearComboBox.isDisplayed()) {
            birthYearComboBox.selectByValue(birthYear);
        }
        viewProductPageButton.clickAndWait();
    }
}
