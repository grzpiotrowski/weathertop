package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import utils.Conversions;
import utils.WeatherAnalytics;

import java.util.Date;

@Entity
public class Reading extends Model {
  public int code;
  public double temperature;
  public int pressure;
  public double windSpeed;
  public double windDirection;
  public Date date;

  public Reading(int code, double temperature, int pressure, double windSpeed, double windDirection, Date dateTime) {
    this.code = code;
    this.temperature = temperature;
    this.pressure = pressure;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.date = dateTime;
  }

  /**
   * Returns temperature value in Fahrenheit degrees.
   *
   * @return Temperature value in Fahrenheit degrees.
   */
  public double getTemperatureFahrenheit() {
    return (temperature * 9 / 5 + 32);
  }

  /**
   * Returns Reading's weather as a String
   *
   * @return Weather String
   */
  public String getWeatherName() {
    return Conversions.weatherCodeToString(code);
  }

  public String getWeatherIcon() {
    return Conversions.weatherCodeIcon(code);
  }

  public int getWindBeaufort() {
    return Conversions.kmhToBeaufort(windSpeed);
  }

  public String getWindCompassDir() {
    return Conversions.azimuthToCompassDir(windDirection);
  }

  public double getWindChill() {
    return WeatherAnalytics.calculateWindChill(temperature, windSpeed);
  }
}
