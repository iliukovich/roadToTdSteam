package steam.steps;

import org.testng.Assert;
import steam.models.Game;
import steam.pages.GameDetailPage;

public class GameDetailPageSteps {

    public static Game getActualInfoAboutGame() {
        Game gameInfoOnDetailPage = new GameDetailPage().getActualGameInfo();
        return gameInfoOnDetailPage;
    }

    public static void assertGameDetailPageIsDisplayed() {
        Assert.assertTrue(new GameDetailPage().isFormDisplayed(), "Game detail page is displayed");
    }

    public static void assertGameName(Game gameActual, Game gameExpected) {
        Assert.assertEquals(gameActual.getName(), gameExpected.getName(), "Games' names are equal");
    }

    public static void assertGameOriginalPrice(Game gameActual, Game gameExpected) {
        Assert.assertEquals(gameActual.getOriginalPrice(), gameExpected.getOriginalPrice(), "Games' original prices are equal");
    }

    public static void assertGameFinalPrice(Game gameActual, Game gameExpected) {
        Assert.assertEquals(gameActual.getFinalPrice(), gameExpected.getFinalPrice(), "Games' final prices are equal");
    }

    public static void assertDiscount(Game gameActual, Game gameExpected) {
        Assert.assertEquals(gameActual.getDiscount(), gameExpected.getDiscount(), "Games' discounts are equal");
    }
}
