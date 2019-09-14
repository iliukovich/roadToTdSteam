package steam.pages;

import a1qa.selenium.elements.interfaces.ILabel;
import a1qa.selenium.forms.BaseForm;
import a1qa.selenium.forms.PageInfo;
import org.openqa.selenium.By;
import steam.helpers.ParseInfo;
import steam.models.Game;

@PageInfo(xpath = "//div[contains(@class, 'game_page')]//div[contains(@class, 'page_content_ctn')]", pageName = "Game detail page")
public class GameDetailPage extends BaseForm {
    private ILabel gameNameLabel = getElementFactory().getLabel(By.className("pageheader"), "game name");
    private ILabel originalPriceLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'purchase')]//div[contains(@class, 'original')]"), "original price");
    private ILabel finalPriceLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'purchase')]//div[contains(@class, 'final')]"), "final price");
    private ILabel discountLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'purchase')]//div[contains(@class, 'discount_pct')]"), "discountLabel");

    public Game getActualGameInfo() {
        Game gameInfoOnDetailPage = new Game();
        gameInfoOnDetailPage.setName(getGameName());

        gameInfoOnDetailPage.setOriginalPrice(getOriginalPrice());
        gameInfoOnDetailPage.setFinalPrice(getFinalPrice());
        gameInfoOnDetailPage.setDiscount(getDiscountValue());

        return gameInfoOnDetailPage;
    }

    private String getGameName() {
        return gameNameLabel.getAttribute("textContent");
    }

    private Double getOriginalPrice() {
        return ParseInfo.parsePrice(originalPriceLabel.getText());
    }

    private Double getFinalPrice() {
        return ParseInfo.parsePrice(finalPriceLabel.getText());
    }

    private Integer getDiscountValue() {
        return ParseInfo.parseDiscount(discountLabel.getText());
    }
}
