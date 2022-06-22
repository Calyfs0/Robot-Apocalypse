package com.Level500.robotapocalypse.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Robot {
    @Id
    private String serialNumber;
    private String model;
    private Date manufacturingDate;
    private String category;
}
