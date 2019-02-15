package com.epam.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.item.model.Category;
import com.epam.item.model.Items;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
