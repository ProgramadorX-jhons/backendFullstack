package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.controller;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Food;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Restaurant;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request.CreateFoodRequest;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.response.MessageResponse;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.FoodService;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.RestaurantService;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
        Food food=foodService.createdFood(req, req.getCategory(),restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        foodService.deleteFood(id);

        MessageResponse res=new MessageResponse();
        res.setMessage("food delete successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailibiityStatus(@PathVariable Long id,
                                                      @RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        Food food=foodService.updateAvailibiityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }


}
