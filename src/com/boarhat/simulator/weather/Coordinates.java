package com.boarhat.simulator.weather;

public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

  public Coordinates(int longitude, int latitude, int height) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.height = height;
  }

  public int getLongitude() {
    return this.longitude;
  }

  public int getLatitude() {
    return this.latitude;
  }

  public int getHeight() {
    return this.height;
  }

  @Override
  public String toString() {
    return "Coordinates{"
        + "longitude='" + this.longitude + "'"
        + ", latitude='" + this.latitude + "'"
        + ", height='" + this.height + "'"
        + "}";
  }
}
