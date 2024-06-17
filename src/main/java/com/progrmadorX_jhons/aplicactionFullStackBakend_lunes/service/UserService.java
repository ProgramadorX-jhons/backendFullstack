package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;

}
