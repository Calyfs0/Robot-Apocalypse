package com.Level500.robotapocalypse.repo;

import com.Level500.robotapocalypse.models.entities.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRobotRepo extends JpaRepository<Robot, String> {

}
