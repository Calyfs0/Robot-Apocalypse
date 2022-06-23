package com.Level500.robotapocalypse.services.interfaces;

import com.Level500.robotapocalypse.models.classes.Location;
import com.Level500.robotapocalypse.models.classes.Robot;
import com.Level500.robotapocalypse.models.classes.flyingRobot;
import com.Level500.robotapocalypse.models.classes.landRobot;
import com.Level500.robotapocalypse.models.interfaces.IFlyingRobot;
import com.Level500.robotapocalypse.models.interfaces.IRobot;

import java.util.ArrayList;
import java.util.List;

public interface IRobotService {

    ArrayList<Robot> getRobotsList();


}
