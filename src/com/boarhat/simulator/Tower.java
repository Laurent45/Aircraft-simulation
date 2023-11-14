package com.boarhat.simulator;

import com.boarhat.simulator.aircraft.Flyable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tower {
  private List<Flyable> observers;

  public Tower() {
    this.observers = new LinkedList<>();
  }

  public void register(Flyable p_flyable) {
    // TODO: add a flyable to observers
  }

  public void unregister(Flyable p_flyable) {
    // TODO: delete this flyable to observers
  }

  protected void conditionChanged() {
  }
}
