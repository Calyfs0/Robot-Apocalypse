package com.Level500.robotapocalypse.repo;

import com.Level500.robotapocalypse.classes.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepo extends JpaRepository<Location, Integer> {
}
