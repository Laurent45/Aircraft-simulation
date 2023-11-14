package com.boarhat.simulator;

import com.boarhat.simulator.aircraft.AircraftFactory;
import com.boarhat.simulator.aircraft.Flyable;
import com.boarhat.simulator.weather.Coordinates;
import com.boarhat.simulator.weather.WeatherTower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;


public class Simulator {

  private static final int TOKENS_PER_LINE = 5;

  public static void main(String[] args) {
    if (args.length != 1) {
      handleException("The scenario text file is required");
    }

    WeatherTower weatherTower = new WeatherTower();

    try {
      // Delete all blank lines in the file
      List<String> lines = Files.readAllLines(Path.of(args[0])).stream()
              .filter(line -> !line.isBlank())
              .toList();

      int numbersOfSimulations = Integer.parseInt(lines.get(0));
      if (numbersOfSimulations < 0) {
        handleException("Numbers of simulations must be a positive integer. Here is " + numbersOfSimulations);
      }

      lines.stream()
              // Skip because is already handle above
              .skip(1L)
              .map(Simulator::toFlyable)
              .forEach(weatherTower::register);

/*
      IntStream.range(0, numbersOfSimulations)
              .forEach(i -> weatherTower.changeWeather());
*/

    } catch (IOException e) {
      handleException("Error while reading lines of this file: " + args[0] + ". " + e.getMessage());
    } catch (NumberFormatException e) {
      handleException("Error while parsing string to a number format. " + e.getMessage());
    } catch (RuntimeException e) {
      handleException(e.getMessage());
    }

  }

  private static Flyable toFlyable(String line) {
    String[] tokens = line.split(" ");
    if (tokens.length != TOKENS_PER_LINE) {
     handleException("Format of the line is incorrect => " + line);
    }

    String aircraftType = tokens[0];
    String aircraftName = tokens[1];
    int longitude = Integer.parseInt(tokens[2]);
    int latitude = Integer.parseInt(tokens[3]);
    int height = Integer.parseInt(tokens[4]);
    Coordinates coordinates = new Coordinates(longitude, latitude, height);

    return AircraftFactory.getInstance().newAircraft(aircraftType, aircraftName, coordinates);
  }

  private static void handleException(String message) {
    System.out.println("ERROR, PROGRAM FAILED => " + message);
    System.exit(1);
  }
}
