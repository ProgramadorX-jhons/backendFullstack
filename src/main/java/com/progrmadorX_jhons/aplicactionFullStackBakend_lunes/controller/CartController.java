package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.controller;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Cart;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.CartItem;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.User;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request.AddCartItemRequest;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.CartService;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PutMapping("/cart/add")
    public ResponseEntity<CartItem> addItemToCart(
            @RequestBody AddCartItemRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {

        CartItem cartItem = cartService.addItemCart(req, jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @PutMapping("/cart_item/update")
    public ResponseEntity<CartItem> updateCartItemQuantity(
            @RequestBody AddCartItemRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {

        CartItem cartItem = cartService.addItemCart(req, jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @DeleteMapping("/cart_item/{id}/remove")
    public ResponseEntity<Cart> removeCartItem(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {

        Cart cart = cartService.removeItemFromCart(id, jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearCart(

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Cart cart = cartService.clearCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> findUserCart(

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Cart cart = cartService.findCartByIdUserId(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

}