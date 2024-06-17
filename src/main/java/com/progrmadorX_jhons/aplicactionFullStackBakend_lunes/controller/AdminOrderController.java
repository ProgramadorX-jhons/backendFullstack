package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.controller;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Order;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.OrderService;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/order/restaurant/{id}")
    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable Long id,
                                                       @RequestParam(required = false)String order_status,
                                                       @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Order> order=orderService.getRestaurantsOrder(id,order_status);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/order/{orderId}/{orderStatus}")
    public ResponseEntity<Order> updateOrdersStatus(@PathVariable Long id,
                                                       @PathVariable String orderStatus,
                                                       @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Order order=orderService.updateOrder(id,orderStatus);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
