package com.Level500.robotapocalypse.services;

import com.Level500.robotapocalypse.enums.Gender;
import com.Level500.robotapocalypse.models.classes.Location;
import com.Level500.robotapocalypse.models.classes.Survivor;
import com.Level500.robotapocalypse.models.interfaces.iInfectedSurvivor;
import com.Level500.robotapocalypse.models.interfaces.iNonInfectedSurvivor;
import com.Level500.robotapocalypse.repo.ISurvivorRepo;
import com.Level500.robotapocalypse.services.interfaces.ISurvivorService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;





@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class survivorService implements ISurvivorService {

    private ISurvivorRepo survivorRepo;

    public Survivor getSurvivorByName(String name){
        return survivorRepo.getSurvivorByName(name);
    }

    public List<Survivor> getSurvivorByGender(Gender gender){
        return survivorRepo.getSurvivorsByGender(gender);
    }

    public List<Survivor> getSurvivorsByNameContainingValue(String value){
        return survivorRepo.getSurvivorsByNameContainingIgnoreCase(value);
    }


    @Override
    public void saveSurvivor(Survivor survivor) {
       survivorRepo.save(survivor);
       log.info("{} Survivor Saved successfully",survivor);
    }

    @Override
    public List<Survivor> getAll() {
        return survivorRepo.findAll();
    }

    @Override
    public List<iInfectedSurvivor> getAllInfected() {
        return survivorRepo.findAll().stream().filter(Survivor::isInfected).collect(Collectors.toList());

    }

    @Override
    public List<iNonInfectedSurvivor> getAllNonInfected() {
        return survivorRepo.findAll().stream().filter(survivor -> !survivor.isInfected()).collect(Collectors.toList());

    }

    @Override
    public double getInfectedSurvivorPercentage() {
        long totalCount = survivorRepo.count();
        long infectedCount = getAllInfected().stream().count();
        double percent = (infectedCount*100)/totalCount;
        return percent;
    }

    @Override
    public double getNonInfectedSurvivorPercentage() {
        long totalCount = survivorRepo.count();
        long infectedCount = getAllNonInfected().stream().count();
        double percent = (infectedCount*100)/totalCount;
        return percent;
    }

    @Override
    public void updateLocation(Long id, Location location) {
        Survivor survivor = survivorRepo.getSurvivorById(id);
        survivor.setLocation(location);
        survivorRepo.save(survivor);
    }

}
