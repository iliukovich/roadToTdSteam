package steam.steps;

import org.testng.Assert;
import steam.models.Game;
import steam.pages.ActionPage;

import java.util.List;

public class ActionPageSteps {

    public static void assertActionPageIsDisplayed() {
        Assert.assertTrue(new ActionPage().isFormDisplayed(), "Action page is displayed");
    }

    public static void selectTopSellers() {
        ActionPage actionPage = new ActionPage();
        actionPage.clickTopSellers();
        Assert.assertTrue(actionPage.isSellingTableDisplayed(), "Selling table is displayed on Action page");
    }

    public static Game getGameWithMaxDiscount() {
        ActionPage actionPage = new ActionPage();
        List<Game> games = actionPage.getListOfGamesWithDiscount();
        Assert.assertTrue(!games.isEmpty(), "Games with discount are found");
        Game gameWithMaxDiscount = actionPage.getGameWithMaxDiscount(games);
        return gameWithMaxDiscount;
    }

    public static void openGameWithDiscount(Game game) {
        new ActionPage().openGameByDiscount(game);
    }
}
