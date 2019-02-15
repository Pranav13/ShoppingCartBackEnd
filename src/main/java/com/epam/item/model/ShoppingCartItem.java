package com.epam.item.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "tb_shoppingcart_items")
@Proxy(lazy=false)
public class ShoppingCartItem implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cartItemId;
	  
	@ManyToOne
	@JoinColumn(name="shoppingcartId")
    private ShoppingCart cart;
 
	@ManyToOne
	@JoinColumn(name="itemsId")
    private Items item;

	@Column(name = "quantity")
	private boolean quantity;

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public boolean isQuantity() {
		return quantity;
	}

	public void setQuantity(boolean quantity) {
		this.quantity = quantity;
	}
	

	

}
