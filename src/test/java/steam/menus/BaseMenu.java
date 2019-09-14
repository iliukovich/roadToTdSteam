package steam.menus;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public abstract class BaseMenu {
    private IButton openMenuButton;
    private String itemTemplateLocator;

    public BaseMenu(By openMenuLocator, String itemTemplateLocator, String menuName) {
        this.openMenuButton = new ElementFactory().getButton(openMenuLocator, menuName);
        this.itemTemplateLocator = itemTemplateLocator;
    }

    public void openMenuByHover() {
        openMenuButton.getMouseActions().moveMouseToElement();
    }

    public void selectItem(String itemName) {
        new ElementFactory().getButton(By.xpath(String.format(itemTemplateLocator, itemName)), itemName).click();
    }
}
