package steam.menus;

import org.openqa.selenium.By;
import steam.enums.GenreMenuItem;

public class GenreMenu extends BaseMenu {

    public GenreMenu() {
        super(By.id("genre_tab"), "//div[contains(@id, 'genre')]//a[contains(., '%s')]", "genre selector");
    }

    public void selectGenre(GenreMenuItem genreMenuItem) {
        super.selectItem(genreMenuItem.getGenreName());
    }
}
