package com.epam.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.item.model.Category;
import com.epam.item.model.Items;
import com.epam.item.repository.ItemRepository;
import com.epam.item.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Items> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public List<Items> getItemsByCategory(Category category) {
		return itemRepository.findByCategory(category);
		
	}



}
