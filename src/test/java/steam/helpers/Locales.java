package steam.helpers;

import helpers.PropertiesResourceManager;

public class Locales {
    private static final String LOC_VALUE_DEFAULT = "en";
    private static final String LOC_VALUE = System.getProperty("lang", LOC_VALUE_DEFAULT);
    private static PropertiesResourceManager langProps = new PropertiesResourceManager(String.format("localization/lang_%s.properties", LOC_VALUE));

    private Locales() {
    }

    public static String getLocale(String key) {
        return langProps.getProperty(key);
    }
}
