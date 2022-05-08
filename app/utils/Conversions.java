package utils;

import java.util.HashMap;
import java.lang.Math;

public class Conversions {

    /**
     * Converts weather code to its String representation
     * @param code Weather code
     * @return Weather name
     */
    public static String weatherCodeToString(int code)
    {
        HashMap<Integer, String> weatherCodes = new HashMap<Integer, String>();
        weatherCodes.put(100, "Clear");
        weatherCodes.put(200, "Partial clouds");
        weatherCodes.put(300, "Cloudy");
        weatherCodes.put(400, "Light Showers");
        weatherCodes.put(500, "Heavy Showers");
        weatherCodes.put(600, "Rain");
        weatherCodes.put(700, "Snow");
        weatherCodes.put(800, "Thunder");

        String weatherName = weatherCodes.get(code);

        return weatherName;
    }

    /**
     * Converts wind speed from km/h to Beaufort scale
     * @param kmh Wind speed in km/h
     * @return Beaufort scale value
     */
    public static int kmhToBeaufort(double kmh)
    {
        if (kmh <= 1) { return 0; }
        else if (kmh > 1 && kmh <= 5) { return 1; }
        else if (kmh > 5 && kmh <= 11) { return 2; }
        else if (kmh > 11 && kmh <= 19) { return 3; }
        else if (kmh > 19 && kmh <= 28) { return 4; }
        else if (kmh > 28 && kmh <= 38) { return 5; }
        else if (kmh > 38 && kmh <= 49) { return 6; }
        else if (kmh > 49 && kmh <= 61) { return 7; }
        else if (kmh > 61 && kmh <= 74) { return 8; }
        else if (kmh > 74 && kmh <= 88) { return 9; }
        else if (kmh > 88 && kmh <= 102) { return 10; }
        else if (kmh > 102 && kmh <= 117) { return 11; }
        else { return 12; }
    }

    /**
     * Converts azimuth (degrees) to compass direction
     * @param azimuth Azimuth value in degrees
     * @return Compass direction
     */
    public static String azimuthToCompassDir(double azimuth)
    {
        if (azimuth > 348.75 && azimuth <= 0.0 ||
        azimuth > 0.0 && azimuth <= 11.25) { return "North"; }
        else if (azimuth > 11.25 && azimuth <= 33.75) { return "North North East"; }
        else if (azimuth > 33.75 && azimuth <= 56.25) { return "North East"; }
        else if (azimuth > 56.25 && azimuth <= 78.75) { return "East North East"; }
        else if (azimuth > 78.75 && azimuth <= 101.25) { return "East"; }
        else if (azimuth > 101.25 && azimuth <= 123.75) { return "East South East"; }
        else if (azimuth > 123.75 && azimuth <= 146.25) { return "South East"; }
        else if (azimuth > 146.25 && azimuth <= 168.75) { return "South South East"; }
        else if (azimuth > 168.75 && azimuth <= 191.25) { return "South"; }
        else if (azimuth > 191.25 && azimuth <= 213.75) { return "South South West"; }
        else if (azimuth > 213.75 && azimuth <= 236.25) { return "South West"; }
        else if (azimuth > 236.25 && azimuth <= 258.75) { return "West South West"; }
        else if (azimuth > 258.75 && azimuth <= 281.25) { return "West"; }
        else if (azimuth > 281.25 && azimuth <= 303.75) { return "West North West"; }
        else if (azimuth > 303.75 && azimuth <= 326.25) { return "North West"; }
        else if (azimuth > 326.25 && azimuth <= 348.75) { return "North North West"; }
        else { return "Unknown"; }
    }

    /**
     * Returns wind chill value for a given temperature and wind conditions
     * @param temperature Temperature in degrees Celsius
     * @param windSpeed Wind velocity in kilometers per hour
     * @return Wind chill value
     */
    public static double calculateWindChill(double temperature, double windSpeed)
    {
        return (13.12 + 0.6215 * temperature - 11.37 * Math.pow(windSpeed, 0.16) + 0.3965 * temperature * Math.pow(windSpeed, 0.16));
    }

}
