package com.Level500.robotapocalypse.repo;

import com.Level500.robotapocalypse.enums.Category;
import com.Level500.robotapocalypse.models.classes.Robot;
import com.Level500.robotapocalypse.models.classes.flyingRobot;
import com.Level500.robotapocalypse.models.interfaces.IRobot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRobotRepo extends JpaRepository<Robot, String> {

}
