package com.epam.item.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_shoppingcart")
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2114870327410506836L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "dateCreated")
	private Date datecreated;
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) List<Items> items
	 * = new ArrayList<>();
	 */
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	/*
	 * public List<Items> getItems() { return items; }
	 * 
	 * public void setItems(List<Items> items) { this.items = items; }
	 */
		
}
