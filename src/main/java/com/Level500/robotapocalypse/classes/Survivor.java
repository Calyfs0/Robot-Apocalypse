package com.Level500.robotapocalypse.classes;

import com.Level500.robotapocalypse.enums.Gender;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "survivors")
public class Survivor {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Gender gender;
    private int age;
    private boolean isInfected;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Location_id", referencedColumnName = "id")
    private Location location;
//
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;
}
