package controllers;

import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    List<Station> stations = Station.findAll();

    render ("dashboard.html", stations);
  }

  /**
   * Adds a new station to the database.
   * @param name Station's name
   */
  public static void addStation(String name)
  {
    Station station = new Station(name);
    Logger.info("Adding a new station: " + name);
    station.save();
    redirect("/dashboard");
  }
}
