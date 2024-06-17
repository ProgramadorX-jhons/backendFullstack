package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Category;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Food;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Restaurant;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createdFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantsFood(Long RestaurantId,
                                         boolean isVegitarain,
                                         boolean isNonveg,
                                         boolean isSeasonal,
                                         String foodCategory
    );

    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;
    public Food updateAvailibiityStatus(Long foodId) throws  Exception;

}
