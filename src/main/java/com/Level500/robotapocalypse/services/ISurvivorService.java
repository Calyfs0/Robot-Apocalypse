package com.Level500.robotapocalypse.services;

import com.Level500.robotapocalypse.classes.Location;
import com.Level500.robotapocalypse.classes.Survivor;


import java.util.List;

public interface ISurvivorService {
    void saveSurvivor(Survivor survivor);
    List<Survivor> getAll();
    List<Survivor> getAllInfected();
    List<Survivor> getAllNonInfected();

    double getInfectedSurvivorPercentage();

    double getNonInfectedSurvivorPercentage();

    void updateLocation(Long id, Location location);
}
