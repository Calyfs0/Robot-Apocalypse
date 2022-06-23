package com.Level500.robotapocalypse.controllers;

import com.Level500.robotapocalypse.models.entities.Robot;
import com.Level500.robotapocalypse.services.interfaces.IRobotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("/api/robot")
public class RobotController {

    private IRobotService robotService;
    @RequestMapping(value = "/getRobotsList", method = RequestMethod.GET)
    public ResponseEntity getRobotsList(){
        ArrayList<Robot> json = robotService.getRobotsList();
        return ResponseEntity.ok(json);
    }

}
