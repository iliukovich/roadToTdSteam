package steam.helpers;

public class ParseInfo {

    public static double parsePrice(String doubleForParse) {
        Double parsedDouble = Double.parseDouble(doubleForParse.replaceAll("[^\\d\\.,]", ""));
        return parsedDouble;
    }

    public static int parseDiscount(String integerForParse) {
        Integer parsedInteger = Integer.parseInt(integerForParse.replaceAll("\\D", ""));
        return parsedInteger;
    }
}
