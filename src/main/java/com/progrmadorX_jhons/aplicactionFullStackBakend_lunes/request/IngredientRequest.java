package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request;

import lombok.Data;

@Data
public class IngredientRequest {

    private String name;
    private Long categoryId;
    private Long restaurantId;
}
