package com.example.shoppingcartbackend.controller;

import java.util.List;

import com.example.shoppingcartbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.shoppingcartbackend.dto.CartItemDto;

@RestController
@RequestMapping("api/v1")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("cartItems")
    public List<CartItemDto> getAllIteam() {
        return cartService.getAllItem();
    }

    @DeleteMapping("cartItems/{id}")
    public void deleteItem(@PathVariable Integer id) {
        cartService.deleteItem(id);
    }

    @PutMapping("{id}/increment")
    public void increItem(@PathVariable Integer id) {
        cartService.increItem(id);
    }

    @PutMapping("{id}/decrement")
    public void decreItem(@PathVariable Integer id) {
        cartService.decreItem(id);
    }
}
