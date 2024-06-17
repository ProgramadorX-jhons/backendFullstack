package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Address;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.ContactInformation;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String opningHouse;
    private List<String> images;

}
