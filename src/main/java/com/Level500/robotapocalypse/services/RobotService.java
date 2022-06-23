package com.Level500.robotapocalypse.services;

import com.Level500.robotapocalypse.enums.Category;
import com.Level500.robotapocalypse.models.classes.*;
import com.Level500.robotapocalypse.models.interfaces.IFlyingRobot;
import com.Level500.robotapocalypse.models.interfaces.IRobot;
import com.Level500.robotapocalypse.repo.IRobotRepo;
import com.Level500.robotapocalypse.services.interfaces.IRobotService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class RobotService implements IRobotService {

    private IRobotRepo iRobotRepo;
    @Autowired
    RobotService(IRobotRepo iRobotRepo){
        this.iRobotRepo = iRobotRepo;
    }
    @Override
    public ArrayList<Robot> getRobotsList() {
            File file = new File("src/main/java/read/robots.json");
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                JSONParser jsonParser = new JSONParser(fileInputStream);
                Object object = jsonParser.parse();

                ArrayList<Robot> arr  = (ArrayList<Robot>) object;
                String robots = new Gson().toJson(arr);
                return arr;
            }
         catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }







}
