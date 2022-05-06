package utils;

import java.util.HashMap;

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

}
