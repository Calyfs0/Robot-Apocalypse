package com.Level500.robotapocalypse.services;

import com.Level500.robotapocalypse.classes.Location;
import com.Level500.robotapocalypse.classes.Survivor;
import com.Level500.robotapocalypse.repo.ILocationRepo;
import com.Level500.robotapocalypse.repo.ISurvivorRepo;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;




@NoArgsConstructor
@Transactional
@Slf4j
@Service
public class survivorService implements ISurvivorService {

    private ISurvivorRepo survivorRepo;
    private ILocationRepo locationRepo;

    @Autowired
    survivorService(ISurvivorRepo survivorRepo, ILocationRepo locationRepo){
        this.survivorRepo = survivorRepo;
        this.locationRepo = locationRepo;
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
    public List<Survivor> getAllInfected() {
        return survivorRepo.findAll().stream().filter(Survivor::isInfected).collect(Collectors.toList());

    }

    @Override
    public List<Survivor> getAllNonInfected() {
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
