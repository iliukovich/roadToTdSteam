package steam.enums;

import steam.helpers.Locales;

public enum GenreMenuItem {
    ACTION("lang.genremenu.action", "lang.actionpage.actiontitle");

    private String genreName;
    private String actionPageHeadline;

    GenreMenuItem(String genreName, String actionPageHeadline) {
        this.genreName = genreName;
        this.actionPageHeadline = actionPageHeadline;
    }

    public String getGenreName() {
        return Locales.getLocale(genreName);
    }

    public String getActionPageHeadline() {
        return Locales.getLocale(actionPageHeadline);
    }
}
