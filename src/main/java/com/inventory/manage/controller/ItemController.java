/**
 * 
 */
package com.inventory.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Item;
import com.inventory.manage.service.item.ItemsService;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemsService itemsService;
	
	
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Item> addItem(@RequestBody  Item item, 
			HttpServletRequest request) {
		
		if (itemsService.isExist(item.getName())) {
			return new ResponseEntity<Item>(HttpStatus.CONFLICT);
		}
		
		Item itemRes = itemsService.addItem(item);
		
		return new ResponseEntity<Item>(itemRes, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getAllItems() {
		List<Item> items = itemsService.getAllItems();
		if(items.isEmpty()){
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteItem(@RequestBody  Item item, 
			HttpServletRequest request) {
		
		boolean result = itemsService.delete(item);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}

}
