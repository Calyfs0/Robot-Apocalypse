package com.Level500.robotapocalypse.repo;

import com.Level500.robotapocalypse.classes.Location;
import com.Level500.robotapocalypse.classes.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ISurvivorRepo extends JpaRepository<Survivor, Long> {
        Survivor getSurvivorById(Long Id);
}
