package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.response;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
