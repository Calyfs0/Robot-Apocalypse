package com.Level500.robotapocalypse.services;

import com.Level500.robotapocalypse.models.entities.*;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
                String result = new Gson().toJson(object);
                ArrayList<Robot> arr = (ArrayList<Robot>) object;
               Robot[] r = new Gson().fromJson(result, Robot[].class);
                AddToDatabase(r);
                return arr;
            }
         catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void AddToDatabase( Robot[] arr ){
        iRobotRepo.saveAll(Arrays.asList(arr));

    }
}
