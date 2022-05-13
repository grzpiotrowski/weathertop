package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;

    render ("dashboard.html", stations);
  }

  /**
   * Adds a new station to the database.
   * @param name Station's name
   */
  public static void addStation(String name)
  {
    Logger.info("Adding a new station: " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name);
    member.stations.add(station);
    station.save();
    redirect("/dashboard");
  }
}
