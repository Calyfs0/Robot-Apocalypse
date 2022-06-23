package com.Level500.robotapocalypse.services.interfaces;

import com.Level500.robotapocalypse.enums.Gender;
import com.Level500.robotapocalypse.models.entities.Location;
import com.Level500.robotapocalypse.models.entities.Survivor;
import com.Level500.robotapocalypse.models.interfaces.iInfectedSurvivor;
import com.Level500.robotapocalypse.models.interfaces.iNonInfectedSurvivor;


import java.util.List;

public interface ISurvivorService {

    Survivor getSurvivorByName(String name);
    void saveSurvivor(Survivor survivor);
    List<Survivor> getAll();
    List<iInfectedSurvivor> getAllInfected();
    List<iNonInfectedSurvivor> getAllNonInfected();

    double getInfectedSurvivorPercentage();

    double getNonInfectedSurvivorPercentage();

    void updateLocation(Long id, Location location);

    List<Survivor> getSurvivorsByNameContainingValue(String value);
    List<Survivor> getSurvivorByGender(Gender gender);

    Survivor reportSurvivorInfection(Long id);
}
