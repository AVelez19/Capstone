package Capstone;

public class CurrencyConverter {

    // Conversion rates (as of a hypothetical date)
    private static final double USD_TO_EUR_RATE = 0.85;
    private static final double USD_TO_GBP_RATE = 0.75;
    private static final double USD_TO_JPY_RATE = 110.50;
    private static final double USD_TO_CAD_RATE = 1.25;
    private static final double USD_TO_INR_RATE = 74.20;
    private static final double USD_TO_MXN_RATE = 20.50;

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        double result = 0.0;
        switch (fromCurrency) {
            case "USD":
                result = convertFromUSD(amount, toCurrency);
                break;
            case "EUR":
                result = convertToUSD(amount, USD_TO_EUR_RATE, toCurrency);
                break;
            case "GBP":
                result = convertToUSD(amount, USD_TO_GBP_RATE, toCurrency);
                break;
            case "JPY":
                result = convertToUSD(amount, USD_TO_JPY_RATE, toCurrency);
                break;
            case "CAD":
                result = convertToUSD(amount, USD_TO_CAD_RATE, toCurrency);
                break;
            case "INR":
                result = convertToUSD(amount, USD_TO_INR_RATE, toCurrency);
                break;
            case "MXN":
                result = convertToUSD(amount, USD_TO_MXN_RATE, toCurrency);
                break;
            default:
                throw new IllegalArgumentException("Unsupported conversion from " + fromCurrency);
        }
        return result;
    }

    private static double convertFromUSD(double amount, String toCurrency) {
        double result = 0.0;
        switch (toCurrency) {
            case "EUR":
                result = amount * USD_TO_EUR_RATE;
                break;
            case "GBP":
                result = amount * USD_TO_GBP_RATE;
                break;
            case "JPY":
                result = amount * USD_TO_JPY_RATE;
                break;
            case "CAD":
                result = amount * USD_TO_CAD_RATE;
                break;
            case "INR":
                result = amount * USD_TO_INR_RATE;
                break;
            case "MXN":
                result = amount * USD_TO_MXN_RATE;
                break;
            default:
                throw new IllegalArgumentException("Unsupported conversion to " + toCurrency);
        }
        return result;
    }

    private static double convertToUSD(double amount, double rate, String toCurrency) {
        if (!toCurrency.equals("USD")) {
            throw new IllegalArgumentException("Unsupported conversion to " + toCurrency);
        }
        return amount / rate;
    }
}
