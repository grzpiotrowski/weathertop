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

    /**
     * Returns temperature value in Fahrenheit degrees.
     * @return Temperature value in Fahrenheit degrees.
     */
    public double getTemperatureFahrenheit()
    {
        return (temperature * 9/5 + 32);
    }

    /**
     * Returns Reading's weather as a String
     * @return Weather String
     */
    public String getWeatherName()
    {
        return Conversions.weatherCodeToString(code);
    }

    public int getWindBeaufort()
    {
        return Conversions.kmhToBeaufort(windSpeed);
    }
}
