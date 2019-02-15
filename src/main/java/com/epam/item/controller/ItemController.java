package com.epam.item.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.item.model.Category;
import com.epam.item.model.Items;
import com.epam.item.model.ShoppingCart;
import com.epam.item.model.ShoppingCartItem;
import com.epam.item.model.response.Meta;
import com.epam.item.model.response.ResponseDTO;
import com.epam.item.service.CategoryService;
import com.epam.item.service.ItemService;
import com.epam.item.service.ShoppingCartItemService;
import com.epam.item.service.ShoppingCartService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*") 
@Api(value = "/", description = "Item Service", produces = "application/json")
public class ItemController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ItemService itemService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ShoppingCartService cartService;
	
	
	  @Autowired 
	  ShoppingCartItemService shoppingCartItemService;
	 

	/*
	 * @ApiOperation(value = "login", response = ResponseDTO.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "login successfully", response =
	 * ResponseDTO.class),
	 * 
	 * @ApiResponse(code = 500, message = "Internal Server Error"),
	 * 
	 * @ApiResponse(code = 404, message = "Invalid Login") })
	 * 
	 * @PostMapping(value = "/login") ResponseEntity<ResponseDTO<?>>
	 * loginUser(@RequestBody User user) { ResponseDTO<?> responseDTO = new
	 * ResponseDTO<>(); Meta meta = new Meta();
	 * 
	 * boolean isValidUser = customerService.isValidUser(user);
	 * 
	 * if (isValidUser) { meta.setResponseCode("1200");
	 * meta.setResponseMessage("login successfully"); responseDTO.setMeta(meta);
	 * return new ResponseEntity<ResponseDTO<?>>(responseDTO,HttpStatus.OK); }
	 * 
	 * 
	 * meta.setResponseCode("1201"); meta.setResponseMessage("invalid login");
	 * responseDTO.setMeta(meta);
	 * log.info("invalid login credentil for user : "+user.getUserName());
	 * return new
	 * ResponseEntity<ResponseDTO<?>>(responseDTO,HttpStatus.UNAUTHORIZED); }
	 */

	@GetMapping(value = "/items")
	ResponseEntity<ResponseDTO<List<Items>>> getItems(@RequestParam(required=false) String categoryId) {
		ResponseDTO<List<Items>> responseDTO = new ResponseDTO<>();
		Meta meta = new Meta();
		List<Items> items = null;
		
		if(categoryId==null) {
			items = itemService.getAllItems();
		} else {
			//items = itemService.getItemsByCategory(category)
		}
		
		if(items == null) {
			meta.setResponseCode("1101");
			meta.setResponseMessage("No Item found");
			responseDTO.setMeta(meta);
			return new ResponseEntity<ResponseDTO<List<Items>>>(responseDTO, HttpStatus.NOT_FOUND);
		}

		meta.setResponseCode("1200");
		meta.setResponseMessage("Item found");
		responseDTO.setMeta(meta);
		responseDTO.setBody(items);
		return new ResponseEntity<ResponseDTO<List<Items>>>(responseDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/category")
	ResponseEntity<ResponseDTO<List<Category>>> getCategories() {
		ResponseDTO<List<Category>> responseDTO = new ResponseDTO<>();
		Meta meta = new Meta();
		List<Category> categories = null;
		
		
		categories = categoryService.getAllCategory();
		
		
		if(categories == null) {
			meta.setResponseCode("1101");
			meta.setResponseMessage("No Item found");
			responseDTO.setMeta(meta);
			return new ResponseEntity<ResponseDTO<List<Category>>>(responseDTO, HttpStatus.NOT_FOUND);
		}

		meta.setResponseCode("1200");
		meta.setResponseMessage("Item found");
		responseDTO.setMeta(meta);
		responseDTO.setBody(categories);
		return new ResponseEntity<ResponseDTO<List<Category>>>(responseDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/shoppingcart")
	ResponseEntity<ResponseDTO<ShoppingCart>> getshoppingCart() {
		ResponseDTO<ShoppingCart> responseDTO = new ResponseDTO<>();
		Meta meta = new Meta();
		ShoppingCart cart = null;
		
		
		cart = cartService.save();
		
		
		if(cart == null) {
			meta.setResponseCode("1101");
			meta.setResponseMessage("No Item found");
			responseDTO.setMeta(meta);
			return new ResponseEntity<ResponseDTO<ShoppingCart>>(responseDTO, HttpStatus.NOT_FOUND);
		}

		meta.setResponseCode("1200");
		meta.setResponseMessage("Item found");
		responseDTO.setMeta(meta);
		responseDTO.setBody(cart);
		return new ResponseEntity<ResponseDTO<ShoppingCart>>(responseDTO, HttpStatus.OK);
	}
	
	
	
	
	  @PostMapping(value="/shoppingcart")
	  ResponseEntity<ResponseDTO<ShoppingCartItem>>
	  insertItems(@RequestParam("cartId")Long cartId, @RequestParam ("itemsKey")
	  Long itemkey) {
	  
	  ResponseDTO<ShoppingCartItem> responseDTO = new ResponseDTO<>(); 
	  Meta meta = new Meta(); 
	  
	  ShoppingCartItem cartItem = null; 
	  ShoppingCartItem saveItem = new ShoppingCartItem();
	  
	  ShoppingCart cart = new ShoppingCart();
	  cart.setId(cartId);
	  Items item = new Items();
	  item.setId(itemkey);
	  
	  saveItem.setCart(cart);
	  saveItem.setItem(item);
	  
	  cartItem = shoppingCartItemService.save(saveItem); 
	  return new ResponseEntity<ResponseDTO<ShoppingCartItem>>(responseDTO, HttpStatus.OK);
	
	  }
	 
	 
	 
	
}
