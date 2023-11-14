package com.boarhat.simulator.aircraft;

import com.boarhat.simulator.weather.Coordinates;

public class Baloon extends Aircraft {

  public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, p_name, p_coordinates);
  }

  @Override
  public void updateConditions() {
    /*
     * SUN - Longitude increases with 2, Height increases with 4
     * RAIN - Height decreases with 5
     * FOG - Height decreases with 3
     * SNOW - Height decreases with 15
     */
  }

  @Override
  public String toString() {
    return "Baloon{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", coordinates=" + coordinates +
            '}';
  }
}
