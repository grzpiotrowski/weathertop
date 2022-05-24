package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.HashSet;
import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    String memberFirstName = member.firstName;
    List<Station> stations = member.stations;

    render ("dashboard.html", stations, memberFirstName);
  }

  /**
   * Adds a new station to the database.
   * @param name Station's name
   * @param latitude Station's latitude coordinate in decimal degrees
   * @param longitude Station's longitude coordinate in decimal degrees
   */
  public static void addStation(String name, double latitude, double longitude)
  {
    Logger.info("Adding a new station: " + name);
    Member member = Accounts.getLoggedInMember();
    HashSet<String> errormessages = new HashSet<>();
    if (member.hasStation(name)) {
      Logger.info("Station name already taken: " + name);
      errormessages.add("Station named " + name + " already exists.");
      List<Station> stations = member.stations;
      render("dashboard.html", stations, errormessages);
    } else {
      Station station = new Station(name, latitude, longitude);
      member.stations.add(station);
      station.save();
      redirect("/dashboard");
    }
  }

  /**
   * Deletes a station from the database
   * @param id Station's id
   */
  public static void deleteStation (Long id)
  {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }

}
