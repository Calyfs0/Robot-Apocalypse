package com.Level500.robotapocalypse.models.entities;

import com.Level500.robotapocalypse.enums.Category;
import com.Level500.robotapocalypse.models.interfaces.IRobot;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Robot implements IRobot {
    @Id
    private String serialNumber;
    private String model;
    private String manufacturingDate;
    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Location_id", referencedColumnName = "id")
    private Location location;

}
