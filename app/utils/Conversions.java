package utils;

public class Conversions {
    /**
     * Converts temperature value from Celsius to Fahrenheit degrees.
     * @param celsius Temperature value in Celsius degrees.
     * @return Temperature value in Fahrenheit degrees.
     */
    public static double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9/5 + 32);
    }

}
