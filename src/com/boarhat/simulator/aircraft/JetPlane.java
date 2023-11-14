package com.boarhat.simulator.aircraft;

import com.boarhat.simulator.weather.Coordinates;

public class JetPlane extends Aircraft {

  public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, p_name, p_coordinates);
  }

  @Override
  public void updateConditions() {
    /*
     * SUN - Latitude increases with 10, Height increases with 2
     * RAIN - Longitude increases with 5
     * FOG - Longitude increases with 1
     * SNOW - Height decreases with 12
     */
  }

  @Override
  public String toString() {
    return "JetPlane{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", coordinates=" + coordinates +
            '}';
  }
}
