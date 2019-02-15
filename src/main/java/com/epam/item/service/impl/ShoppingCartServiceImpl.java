package com.epam.item.service.impl;

import java.util.Date;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.item.model.ShoppingCart;
import com.epam.item.repository.ShoppingCartRepository;
import com.epam.item.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	ShoppingCartRepository cartRepository; 

	public ShoppingCart save() {
		// TODO Auto-generated method stub
		 ShoppingCart cart = new ShoppingCart();
		 //cart.setId(1L);
		 cart.setDatecreated(new Date());
		return cartRepository.save(cart);
	}

	@Override
	public ShoppingCart save(ShoppingCart item) {
		// TODO Auto-generated method stub
		return cartRepository.save(item);
	}


}
