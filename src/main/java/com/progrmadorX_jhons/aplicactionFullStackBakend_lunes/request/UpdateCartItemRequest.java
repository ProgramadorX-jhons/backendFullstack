package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {

    private Long cartItemId;
    private int quantity;
}
