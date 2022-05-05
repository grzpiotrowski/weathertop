package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model
{
    public String name;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name)
    {
        this.name = name;
    }

    /**
     * Returns the most recent reading for the station
     * @return The last weather reading for the station
     */
    public Reading getLastReading()
    {
        return this.readings.get(readings.size() - 1);
    }
}
