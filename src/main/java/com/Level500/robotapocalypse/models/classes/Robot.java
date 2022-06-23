package com.Level500.robotapocalypse.models.classes;

import com.Level500.robotapocalypse.enums.Category;
import com.Level500.robotapocalypse.models.interfaces.IRobot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Robot implements IRobot {
    @Id
    @Column(name = "serialnumber")
    private String serialNumber;
    private String model;
    @Column(name = "manufacturingdate")
    private Date manufacturingDate;
    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Location_id", referencedColumnName = "id")
    private Location location;

}
