package com.epam.item.service;

import java.util.Date;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.epam.item.model.ShoppingCart;


public interface ShoppingCartService {
	ShoppingCart save();
	ShoppingCart save(ShoppingCart item);
}
