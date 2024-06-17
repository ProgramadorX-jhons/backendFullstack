package com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.service;

import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.Cart;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.model.CartItem;
import com.progrmadorX_jhons.aplicactionFullStackBakend_lunes.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemCart(AddCartItemRequest req, String jwt)throws Exception;

    public CartItem updateCartItemQuantity(Long cartItemId,int quantity)throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt)throws Exception;

    public Long calculateCartTotals(Cart cart) throws Exception;

    public Cart findCartById(Long id)throws Exception;

    public Cart findCartByIdUserId(Long userId)throws Exception;

    public Cart clearCart(Long userId)throws Exception;


}
