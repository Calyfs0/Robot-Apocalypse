package com.Level500.robotapocalypse.models.entities;

import com.Level500.robotapocalypse.models.interfaces.iSurvivor;
import com.Level500.robotapocalypse.enums.Gender;
import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "survivors")
public class Survivor implements iSurvivor {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @ReadOnlyProperty
    private Long id;
    private String name;
    private Gender gender;
    private int age;
    private boolean isInfected;
    private int infectedReportCount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Location_id", referencedColumnName = "id")
    private Location location;
//
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;
}
