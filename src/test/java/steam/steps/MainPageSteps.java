package steam.steps;

import steam.enums.GenreMenuItem;
import steam.menus.GenreMenu;

public class MainPageSteps {

    public static void selectGenreFromMainMenu() {
        GenreMenu genreMenu = new GenreMenu();
        genreMenu.openMenuByHover();

        genreMenu.selectGenre(GenreMenuItem.ACTION);
    }
}
