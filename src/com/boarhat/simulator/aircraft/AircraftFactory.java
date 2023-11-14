package com.boarhat.simulator.aircraft;

import com.boarhat.simulator.weather.Coordinates;

public class AircraftFactory {

  private static AircraftFactory aircraftFactory;
  private static long id = 0;

  private AircraftFactory() {
  }

  public static AircraftFactory getInstance() {
    if (aircraftFactory == null) {
      aircraftFactory = new AircraftFactory();
    }
    return aircraftFactory;
  }

  public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
    return switch (AircraftType.valueOf(p_type.toUpperCase())) {
      case JETPLANE -> new JetPlane(id++, p_name, p_coordinates);
      case HELICOPTER -> new Helicopter(id++, p_name, p_coordinates);
      case BALOON -> new Baloon(id++, p_name, p_coordinates);
    };
  }
}
