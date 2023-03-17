package com.example.shoppingcartbackend.service;

import com.example.shoppingcartbackend.dto.CartItemDto;
import com.example.shoppingcartbackend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItemDto> getAllItem() {
        return cartItemRepository.getAllItem();
    }

    public void deleteItem(Integer id) {
        cartItemRepository.deleteItem(id);
    }

    public void increItem(Integer id) {
        cartItemRepository.increItem(id);
    }

    public void decreItem(Integer id) {
        cartItemRepository.decreItem(id);
    }
}
