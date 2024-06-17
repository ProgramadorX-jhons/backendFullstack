package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.dto.RestaurantDto;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Restaurant;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestarant(CreateRestaurantRequest rep, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant ) throws  Exception;

    public void  deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws  Exception;

    public Restaurant getRestaurantByUserId(Long userId)throws Exception;

    public RestaurantDto addToFavorites(Long restaurantId,User user)throws  Exception;

    public Restaurant updateRestaurantStatus(Long id) throws  Exception;

}
