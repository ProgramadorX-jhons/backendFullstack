package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address deliviryAddress;
}
