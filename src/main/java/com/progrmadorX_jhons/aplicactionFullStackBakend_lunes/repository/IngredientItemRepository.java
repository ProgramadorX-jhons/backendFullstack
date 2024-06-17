package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.IngredientsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientItemRepository extends JpaRepository<IngredientsItem, Long> {

    List<IngredientsItem> findByRestaurantId(Long id);

}
