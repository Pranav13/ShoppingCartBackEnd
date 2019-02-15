package com.epam.item.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.item.model.ShoppingCart;
import com.epam.item.model.ShoppingCartItem;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{

	ShoppingCartItem save(ShoppingCartItem item);
}
