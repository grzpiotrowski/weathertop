package utils;

import models.Reading;

import java.util.List;

/**
 * The WeatherAnalytics class contains static methods for analysis on weather readings
 *
 * @author: Grzegorz Piotrowski
 * @version: 0.1 (16.May.2022)
 */
public class WeatherAnalytics {

  /**
   * Returns wind chill value for a given temperature and wind conditions
   *
   * @param temperature Temperature in degrees Celsius
   * @param windSpeed   Wind velocity in kilometers per hour
   * @return Wind chill value
   */
  public static double calculateWindChill(double temperature, double windSpeed) {
    return (13.12 + 0.6215 * temperature - 11.37 * Math.pow(windSpeed, 0.16) + 0.3965 * temperature * Math.pow(windSpeed, 0.16));
  }

  /**
   * Returns a reading with the maximum temperature
   * @param readings List of Readings
   * @return Reading with max temperature
   */
  public static Reading getMaxTemperatureReading(List<Reading> readings) {
    Reading maxTempReading = null;
    if (readings.size() > 0) {
      maxTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temperature > maxTempReading.temperature) {
          maxTempReading = reading;
        }
      }
    }
    return maxTempReading;
  }

  /**
   * Returns a reading with the minimum temperature
   * @param readings List of Readings
   * @return Reading with min temperature
   */
  public static Reading getMinTemperatureReading(List<Reading> readings) {
    Reading minTempReading = null;
    if (readings.size() > 0) {
      minTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temperature < minTempReading.temperature) {
          minTempReading = reading;
        }
      }
    }
    return minTempReading;
  }

  /**
   * Returns a reading with the maximum wind speed
   * @param readings List of Readings
   * @return Reading with max wind speed
   */
  public static Reading getMaxWindReading(List<Reading> readings) {
    Reading maxWindReading = null;
    if (readings.size() > 0) {
      maxWindReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed > maxWindReading.windSpeed) {
          maxWindReading = reading;
        }
      }
    }
    return maxWindReading;
  }

  /**
   * Returns a reading with the minimum wind speed
   * @param readings List of Readings
   * @return Reading with min wind speed
   */
  public static Reading getMinWindReading(List<Reading> readings) {
    Reading minWindReading = null;
    if (readings.size() > 0) {
      minWindReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed < minWindReading.windSpeed) {
          minWindReading = reading;
        }
      }
    }
    return minWindReading;
  }

  /**
   * Returns a reading with the maximum pressure
   * @param readings List of Readings
   * @return Reading with max pressure
   */
  public static Reading getMaxPressureReading(List<Reading> readings) {
    Reading maxPressureReading = null;
    if (readings.size() > 0) {
      maxPressureReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure > maxPressureReading.pressure) {
          maxPressureReading = reading;
        }
      }
    }
    return maxPressureReading;
  }

  /**
   * Returns a reading with the minimum pressure
   * @param readings List of Readings
   * @return Reading with min pressure
   */
  public static Reading getMinPressureReading(List<Reading> readings) {
    Reading minPressureReading = null;
    if (readings.size() > 0) {
      minPressureReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure < minPressureReading.pressure) {
          minPressureReading = reading;
        }
      }
    }
    return minPressureReading;
  }

}