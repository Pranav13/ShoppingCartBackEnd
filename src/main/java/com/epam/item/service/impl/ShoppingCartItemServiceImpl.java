package com.epam.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.item.model.ShoppingCartItem;
import com.epam.item.repository.ShoppingCartRepository;
import com.epam.item.service.ShoppingCartItemService;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCartItem save(ShoppingCartItem item) {
		// TODO Auto-generated method stub
		return shoppingCartRepository.save(item);
	}

}
