package com.epam.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.item.model.ShoppingCart;
import com.epam.item.model.ShoppingCartItem;

@Repository
public interface ShoppingCartItemRepository  extends JpaRepository<ShoppingCartItem, Long> {

}
