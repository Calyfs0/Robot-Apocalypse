package com.Level500.robotapocalypse.models.classes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int water;
    private int food;
    private int ammunition;
    private int medication;
}
