package com.boarhat.simulator.aircraft;

import com.boarhat.simulator.weather.WeatherTower;

public abstract class Flyable {

  protected WeatherTower weatherTower;

  public abstract void updateConditions();

  public void registerTower(WeatherTower p_tower) {
    return;
  }
}
