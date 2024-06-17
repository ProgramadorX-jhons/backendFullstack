package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Cart;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomerId(Long customerId);
}
