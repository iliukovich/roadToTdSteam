package steam.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AgeValidationPage extends Form {

    private IComboBox birthYearComboBox = getElementFactory().getComboBox(By.id("ageYear"), "birth year");
    private IButton viewProductPageButton = getElementFactory().getButton(By.xpath("//div[contains(@class, 'agegate')]//a[@onclick]"), "view product page");

    public AgeValidationPage() {
        super(
                By.xpath("//div[contains(@id, 'app_agegate')]"),
                "Age validation page"
        );
    }

    public void validateAge(String birthYear) {
        if (birthYearComboBox.state().isDisplayed()) {
            birthYearComboBox.selectByValue(birthYear);
        }
        viewProductPageButton.clickAndWait();
    }
}
