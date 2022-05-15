package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model {
  public String name;
  public double latitude;
  public double longitude;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Returns the most recent reading for the station
   *
   * @return The last weather reading for the station
   */
  public Reading getLastReading() {
    Reading lastReading = null;
    if (readings.size() > 0) {
      lastReading = readings.get(readings.size() - 1);
    }
    return lastReading;
  }

}
