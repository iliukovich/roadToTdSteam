package steam.steps;

import steam.pages.AgeValidationPage;

public class AgeValidationPageSteps {

    public static void validateAgeOfUser() {
        AgeValidationPage ageValidationPage = new AgeValidationPage();
        if (ageValidationPage.isFormDisplayed()) {
            ageValidationPage.validateAge("1990");
        }
    }
}
