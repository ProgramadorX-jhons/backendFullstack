package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.cofing.JwtProvider;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found");
        }
        return user;
    }
}
