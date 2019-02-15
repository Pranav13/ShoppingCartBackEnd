package com.epam.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.item.model.Category;
import com.epam.item.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
	
	List<Items> findByCategory(Category category);
}
