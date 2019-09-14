package steam.steps;

import aqa.assertion.AqaAssert;
import steam.models.Game;
import steam.pages.ActionPage;

import java.util.List;

public class ActionPageSteps {

    public static void assertActionPageIsDisplayed() {
        AqaAssert.isTrue(new ActionPage().isFormDisplayed(), "Action page is displayed");
    }

    public static void selectTopSellers() {
        ActionPage actionPage = new ActionPage();
        actionPage.clickTopSellers();
        AqaAssert.isTrue(actionPage.isSellingTableDisplayed(), "Selling table is displayed on Action page");
    }

    public static Game getGameWithMaxDiscount() {
        ActionPage actionPage = new ActionPage();
        List<Game> games = actionPage.getListOfGamesWithDiscount();
        AqaAssert.isTrue(!games.isEmpty(), "Games with discount are found");
        Game gameWithMaxDiscount = actionPage.getGameWithMaxDiscount(games);
        return gameWithMaxDiscount;
    }

    public static void openGameWithDiscount(Game game) {
        new ActionPage().openGameByDiscount(game);
    }
}
