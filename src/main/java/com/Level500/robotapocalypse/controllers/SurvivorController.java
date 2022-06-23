package com.Level500.robotapocalypse.controllers;

import com.Level500.robotapocalypse.models.classes.Location;
import com.Level500.robotapocalypse.models.classes.Survivor;
import com.Level500.robotapocalypse.models.interfaces.iInfectedSurvivor;
import com.Level500.robotapocalypse.models.interfaces.iNonInfectedSurvivor;
import com.Level500.robotapocalypse.services.interfaces.ISurvivorService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/survivor")
public class SurvivorController {
    private ISurvivorService survivorService;

    @RequestMapping(value = "/survivalists", method = RequestMethod.GET)
    public ResponseEntity getAllSurvivors(){
             List<Survivor> survivorList = survivorService.getAll();
             return ResponseEntity.ok(survivorList);
    }

    @PostMapping(value = "/addSurvivor")
    public void AddSurvivor(@RequestBody Survivor survivor){
        survivorService.saveSurvivor(survivor);
    }
    @PostMapping(value = "/updateLocation")
    public void AddLocation(@RequestBody Long id, Location location){
        survivorService.updateLocation(id,location);
    }

    @RequestMapping(value = "/infectedsurvivorlists", method = RequestMethod.GET)
    public ResponseEntity getInfectedSurvivors(){
        List<iInfectedSurvivor> infectedSurvivorList = survivorService.getAllInfected();
        return ResponseEntity.ok(infectedSurvivorList);
    }

    @RequestMapping(value = "/nonInfectedsurvivorlists", method = RequestMethod.GET)
    public ResponseEntity getNonInfectedSurvivors(){
        List<iNonInfectedSurvivor> infectedSurvivorList = survivorService.getAllNonInfected();
        return ResponseEntity.ok(infectedSurvivorList);
    }

    @RequestMapping(value = "/infectedSurvivorPercentage", method = RequestMethod.GET)
    public ResponseEntity getInfectedSurvivorsPercent(){
        double percentage = survivorService.getInfectedSurvivorPercentage();
        return ResponseEntity.ok(percentage);
    }

    @RequestMapping(value = "/nonInfectedSurvivorPercentage", method = RequestMethod.GET)
    public ResponseEntity getNonInfectedSurvivorsPercent(){
       double percentage = survivorService.getNonInfectedSurvivorPercentage();
        return ResponseEntity.ok(percentage);
    }




}
