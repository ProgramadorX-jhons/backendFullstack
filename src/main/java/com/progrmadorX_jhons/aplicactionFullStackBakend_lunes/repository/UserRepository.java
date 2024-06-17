package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

    public User findByEmail(String username);
}
