package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import play.db.jpa.Model;
import utils.WeatherAnalytics;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model {
  public String name;
  public double latitude;
  public double longitude;

  @OneToMany(cascade = CascadeType.ALL)
  @OrderBy("date ASC")
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Returns the most recently added reading for the station
   * Note: Not necessarily the newest by date
   * @return The most recently added weather reading for the station
   */
  public Reading getLastReading() {
    Reading lastReading = null;
    if (readings.size() > 0) {
      lastReading = readings.get(readings.size() - 1);
    }
    return lastReading;
  }

  /**
   * Returns a reading which is the most recent by date for the station
   * @return The latest weather reading for the station
   */
  public Reading getLatestReading() {
    Reading latestReading = null;
    if (readings.size() > 0) {
      latestReading = readings.get(0);
      for (Reading reading:readings) {
        if (reading.date.after(latestReading.date)) {
          latestReading = reading;
        }
      }
    }
    return latestReading;
  }

  public Reading getMinTemperatureReading() {
    return WeatherAnalytics.getMinTemperatureReading(readings);
  }

  public Reading getMaxTemperatureReading() {
    return WeatherAnalytics.getMaxTemperatureReading(readings);
  }

  public Reading getMinPressureReading() {
    return WeatherAnalytics.getMinPressureReading(readings);
  }

  public Reading getMaxPressureReading() {
    return WeatherAnalytics.getMaxPressureReading(readings);
  }

  public Reading getMinWindReading() {
    return WeatherAnalytics.getMinWindReading(readings);
  }

  public Reading getMaxWindReading() {
    return WeatherAnalytics.getMaxWindReading(readings);
  }
}
