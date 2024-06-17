package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.dto.RestaurantDto;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Address;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Restaurant;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository.AddressRepository;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository.RestaurantRepository;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository.UserRepository;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Restaurant createRestarant(CreateRestaurantRequest rep, User user) {
        Address address=addressRepository.save(rep.getAddress());

        Restaurant restaurant=new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContactInformation(rep.getContactInformation());
        restaurant.setCuisineType(rep.getCuisineType());
        restaurant.setDescription(rep.getDescription());
        restaurant.setImages(rep.getImages());
        restaurant.setName(rep.getName());
        restaurant.setOpeningHours(rep.getCuisineType());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);

        if (restaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }
        if (restaurant.getDescription()!=null){
            restaurant.setDescription(updateRestaurant.getDescription());
        }
        if (restaurant.getName()!=null){
            restaurant.setName(updateRestaurant.getName());
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

        Restaurant restaurant=findRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);

    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        Optional<Restaurant> opt=restaurantRepository.findById(id);

        if(opt.isEmpty()){
            throw  new Exception("restaurant not found whit id"+id);
        }
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant=restaurantRepository.findByOwnerId(userId);
        if(restaurant==null){
            throw new Exception("restaurant not found with owner in"+userId);
        }
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);

        RestaurantDto dto=new RestaurantDto();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurantId);

        if(user.getFavorites().contains(dto)){
            user.getFavorites().remove(dto);
        }else user.getFavorites().add(dto);

        userRepository.save(user);
        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant=findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());

        return restaurantRepository.save(restaurant);
    }
}
