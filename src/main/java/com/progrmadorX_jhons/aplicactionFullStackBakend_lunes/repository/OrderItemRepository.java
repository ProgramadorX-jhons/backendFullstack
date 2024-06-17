package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.repository;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
