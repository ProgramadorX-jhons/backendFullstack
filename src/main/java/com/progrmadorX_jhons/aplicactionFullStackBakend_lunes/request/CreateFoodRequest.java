package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Category;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarin;
    private boolean seasional;
    private List<IngredientsItem> ingredients;
}
