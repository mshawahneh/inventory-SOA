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

import com.inventory.manage.model.Catalog;
import com.inventory.manage.service.catalog.CatalogService;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	/**
	 * Create new catalog 
	 * @param catalog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Catalog> addCatalog(@RequestBody  Catalog catalog, 
			HttpServletRequest request) {
		
		// Check if catalog existed before
		if (catalogService.isExist(catalog.getName())) {
			return new ResponseEntity<Catalog>(HttpStatus.CONFLICT);
		}
		
		Catalog catalogRes = catalogService.addCatalog(catalog);
		
		return new ResponseEntity<Catalog>(catalogRes, HttpStatus.OK);
	}

	/**
	 * Get all catalogs
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Catalog>> getAllCatalogs() {
		List<Catalog> catalogs = catalogService.getAllCatalogs();
		if(catalogs.isEmpty()){
			return new ResponseEntity<List<Catalog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Catalog>>(catalogs, HttpStatus.OK);		
    }
	
	/**
	 * Delete catalog
	 * @param catalog
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteCatalog(@RequestBody  Catalog catalog, 
			HttpServletRequest request) {
		
		boolean result = catalogService.delete(catalog);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}

}
