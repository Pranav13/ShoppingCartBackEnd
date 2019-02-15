package com.epam.item.service;

import java.util.List;

import com.epam.item.model.Category;
import com.epam.item.model.Items;

public interface ItemService {
	
	List<Items> getAllItems();
	
	public List<Items> getItemsByCategory(Category category);
}
