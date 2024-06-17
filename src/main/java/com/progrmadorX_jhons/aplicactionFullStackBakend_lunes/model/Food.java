package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long price;

    @ManyToOne
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection // Creará una tabla separada para las imágenes de la comida
    private List<String> images;

    private boolean available;

    @ManyToOne  // Muchos alimentos que ofrece
    private Restaurant restaurant;

    private boolean isVegetarian; // Comida vegetariana

    private boolean isSeasonal;

    @ManyToMany
    @JoinTable(
            name = "food_ingredients",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientsItem> ingredients = new ArrayList<>();

    private Date creationDate;
}
