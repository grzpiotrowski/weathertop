package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.Play;
import play.mvc.Controller;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    render("station.html", station);
  }

  /**
   * Adds a new reading to the station
   *
   * @param id            Station's id
   * @param code          Weather code
   * @param temperature   Temperature value in degrees Celsius
   * @param pressure      Pressure value
   * @param windSpeed     Wind speed value in km per hour
   * @param windDirection Wind direction in degrees
   */
  public static void addReading(Long id, int code, double temperature, int pressure, double windSpeed, double windDirection) {
    Reading song = new Reading(code, temperature, pressure, windSpeed, windDirection);
    Station station = Station.findById(id);
    station.readings.add(song);
    station.save();

    redirect("/stations/" + id);
  }

  /**
   * Removes a reading from the station
   * @param id Station's id
   * @param readingid Reading's id
   */
  public static void deleteReading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing " + reading.id);
    station.readings.remove(reading);
    station.save();
    reading.delete();

    redirect("/stations/" + id);
  }

}