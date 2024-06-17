package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.IngredientsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class IngredientCategoryRequest {

    private String name;
    private Long restaurantId;
}
