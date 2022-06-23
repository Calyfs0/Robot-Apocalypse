package com.Level500.robotapocalypse.services;

import com.Level500.robotapocalypse.enums.Gender;
import com.Level500.robotapocalypse.models.entities.Location;
import com.Level500.robotapocalypse.models.entities.Survivor;
import com.Level500.robotapocalypse.models.interfaces.iInfectedSurvivor;
import com.Level500.robotapocalypse.models.interfaces.iNonInfectedSurvivor;
import com.Level500.robotapocalypse.repo.ISurvivorRepo;
import com.Level500.robotapocalypse.services.interfaces.ISurvivorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;






@Transactional
@Slf4j
@Service
public class survivorService implements ISurvivorService {

    private ISurvivorRepo survivorRepo;
    @Autowired
    survivorService(ISurvivorRepo survivorRepo){
        this.survivorRepo = survivorRepo;
    }
    public Survivor getSurvivorByName(String name){
        return survivorRepo.getSurvivorByName(name);
    }

    public List<Survivor> getSurvivorByGender(Gender gender){
        return survivorRepo.getSurvivorsByGender(gender);
    }

    @Override
    public Survivor reportSurvivorInfection(Long id) {
        Survivor survivor = survivorRepo.getSurvivorById(id);
        int currentCount = survivor.getInfectedReportCount();
        currentCount++;
        if(currentCount == 3){
            survivor.setInfected(true);
        }
        survivor.setInfectedReportCount(currentCount);
        survivorRepo.save(survivor);
        return survivor;
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
