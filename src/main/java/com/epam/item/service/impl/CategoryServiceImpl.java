package com.epam.item.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.item.model.Category;
import com.epam.item.repository.CategoryRepository;
import com.epam.item.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	

	
	
}
