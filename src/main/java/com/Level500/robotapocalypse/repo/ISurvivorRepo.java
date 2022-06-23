package com.Level500.robotapocalypse.repo;

import com.Level500.robotapocalypse.enums.Gender;
import com.Level500.robotapocalypse.models.classes.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ISurvivorRepo extends JpaRepository<Survivor, Long> {
        Survivor getSurvivorById(Long Id);
        Survivor getSurvivorByName(String name);
        List<Survivor> getSurvivorsByNameContainingIgnoreCase(String name);
        List<Survivor> getSurvivorsByGender(Gender gender);

}
