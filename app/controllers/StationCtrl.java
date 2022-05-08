package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.Play;
import play.mvc.Controller;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info("Playlist id = " + id);
        render("dashboard.html");
    }

    public static void addReading(Long id, int code, double temperature, int pressure, double windSpeed, double windDirection)
    {
        Reading song = new Reading(code, temperature, pressure, windSpeed, windDirection);
        Station station = Station.findById(id);
        station.readings.add(song);
        station.save();

        redirect("/dashboard");
    }


}