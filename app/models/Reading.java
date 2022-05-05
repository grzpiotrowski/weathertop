package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import utils.Conversions;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public int pressure;
    public double windSpeed;

    public Reading(int code, double temperature, int pressure, double windSpeed)
    {
        this.code = code;
        this.temperature = temperature;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

}
