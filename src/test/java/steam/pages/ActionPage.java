package steam.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import steam.enums.GenreMenuItem;
import steam.helpers.ParseInfo;
import steam.models.Game;

import java.util.ArrayList;
import java.util.List;

public class ActionPage extends Form {

    private IButton topSellersButton = getElementFactory().getButton(By.id("tab_select_TopSellers"), "topSellersButton");
    private ILabel topSellingTable = getElementFactory().getLabel(By.xpath("//div[contains(@id, 'tab_content_TopSellers') and contains(@style, 'block')]"), "topSellingTable");
    private By gameElementWithDiscount = By.xpath("//div[contains(@id, 'tab_content_TopSellers')]//a[.//div[contains(@class, 'original_price')]]");
    private String gameElementWithMaxDiscount = "//div[contains(@id, 'tab_content_TopSellers')]//a[.//div[contains(@class, 'discount_pct') and contains(., '%s')]]";
    private By gameName = By.xpath(".//div[contains(@class, 'tab_item_name')]");
    private By originalPriceOfGameWithDiscount = By.xpath(".//div[contains(@class, 'original_price')]");
    private By finalPriceOfGameWithDiscount = By.xpath(".//div[contains(@class, 'final_price')]");
    private By discount = By.xpath(".//div[contains(@class, 'discount_pct')]");

    public ActionPage() {
        super(By.xpath(String.format("//h2[contains(., '%s')]", GenreMenuItem.ACTION.getActionPageHeadline())), "ActionPage");
    }

    public void clickTopSellers() {
        topSellersButton.clickAndWait();
    }

    public boolean isSellingTableDisplayed() {
        return topSellingTable.state().waitForDisplayed();
    }

    private List<ILabel> getListOfGamesElementsWithDiscount() {
        return getElementFactory().findElements(gameElementWithDiscount, ElementType.LABEL);
    }

    public List<Game> getListOfGamesWithDiscount() {
        List<Game> gameList = new ArrayList<>();

        for (ILabel gameElement : getListOfGamesElementsWithDiscount()) {
            Game game = new Game();
            String name = gameElement.findChildElement(gameName, ElementType.LABEL).getText();
            game.setName(name);

            String originalPrice = gameElement.findChildElement(originalPriceOfGameWithDiscount, ElementType.LABEL).getText();
            game.setOriginalPrice(ParseInfo.parsePrice(originalPrice));

            String finalPrice = gameElement.findChildElement(finalPriceOfGameWithDiscount, ElementType.LABEL).getText();
            game.setFinalPrice(ParseInfo.parsePrice(finalPrice));

            String discountValue = gameElement.findChildElement(discount, ElementType.LABEL).getText();
            game.setDiscount(ParseInfo.parseDiscount(discountValue));

            gameList.add(game);
        }
        return gameList;
    }

    public Game getGameWithMaxDiscount(List<Game> gameList) {
        Game gameWithMaxDiscount = new Game();
        int maxDiscount = Integer.MIN_VALUE;

        for (Game game : gameList) {
            if (game.getDiscount() > maxDiscount) {
                maxDiscount = game.getDiscount();
                gameWithMaxDiscount = game;
            }
        }
        return gameWithMaxDiscount;
    }

    private ILabel getGameElement(int discount) {
        return getElementFactory().getLabel(By.xpath(String.format(gameElementWithMaxDiscount, discount)), "game with max discount");
    }

    public void openGameByDiscount(Game game) {
        getGameElement(game.getDiscount()).click();
    }
}
