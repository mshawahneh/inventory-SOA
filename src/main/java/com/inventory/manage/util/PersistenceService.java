/**
 * 
 */
package com.inventory.manage.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inventory.manage.model.Customer;
import com.inventory.manage.model.Persistable;

/**
 * @author mshawahn
 *
 */
public class PersistenceService {

	static Map<String, Persistable> persistenceMap = new HashMap<String, Persistable>();

	public static void save(Persistable itemToSave){
		persistenceMap.put(itemToSave.getId(), itemToSave);
		
	}
	
	public static void update(Persistable itemToSave){
		save(itemToSave);
	}
	
	public static void delete(Persistable itemToSave){
		persistenceMap.remove(itemToSave.getId());
	}
	
	public static List<Persistable> get(String type){
		
		Collection<Persistable> items = persistenceMap.values();
		List<Persistable> resultSet = new ArrayList<Persistable>();
		for (Persistable persistable : items) {
			
			if(persistable.getType().equals(type)){
				resultSet.add(persistable);
			}
		}
		return resultSet;
		
	}
	
	public static Object getById(String id){
		return persistenceMap.get(id);
	}
}
