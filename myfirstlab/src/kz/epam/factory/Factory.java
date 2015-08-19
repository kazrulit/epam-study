package kz.epam.factory;

import java.util.*;

import kz.epam.shop.*;
/**
 * <h1>Factory class that has ability to push new objects to the one or more shops</h1>
 * 
 * @author MR_SPEC
 * @version 1.0
 *
 */
public class Factory {
	/** Auto-increment id that will be increased by 1 
	 * whenever you add new object to the list **/
	private int id = 0;

	private List<Toys> list;
	private Map shopMap;
	private String shopName;
	
	/**
	 * Default constructor that initializes ArrayList constructor 
	 * to the created List object class. Also putting list to the Map with the given key name of
	 * shop.
	 */
	public Factory() {
		this.list = new ArrayList<Toys>();
		this.shopMap = new HashMap();
		this.shopName = "default";
		this.shopMap.put(this.shopName, list);
	}
	
	public Factory(String shopName) {
		this.list = new ArrayList<Toys>();
		this.shopMap = new HashMap();
		this.shopName = shopName;
		this.shopMap.put(this.shopName, list);
	}
	
	/**
	 * <p>Set shop name for Map, that we will use on calling methods</p>
	 * @param shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
		
		/** Creates new list, if the given shop name never used **/
		if(shopMap.get(this.shopName) == null) {
			list = new ArrayList<Toys>();
			shopMap.put(shopName, list);
		}
		else {
			list = (List<Toys>) shopMap.get(shopName);
		}
	}
	
	/**Add sport object to the shop, with different type of price **/
	public void addSport(String name, int price) {
		id++;
		list.add(new Sport(id, name, price));
		shopMap.put(this.shopName, list);
	}
	
	public void addSport(String name, String price) {
		id++;
		list.add(new Sport(id, name, Integer.valueOf(price)));
		shopMap.put(shopName, list);
	}
	
	public void addSport(String name, double price) {
		id++;
		list.add(new Sport(id, name, (int)price));
		shopMap.put(shopName, list);
	}
	
	/**Add logical game object to the shop, with different type of price **/
	public void addLogical(String name, int price) {
		id++;
		list.add(new Logical(id, name, price));
		shopMap.put(shopName, list);
	}
	
	public void addLogical(String name, String price) {
		id++;
		list.add(new Logical(id, name, Integer.valueOf(price)));
		shopMap.put(shopName, list);
	}
	
	public void addLogical(String name, double price) {
		id++;
		list.add(new Logical(id, name, (int)price));
		shopMap.put(shopName, list);
	}
	
	/** Get list that may contain objects **/
	public List<Toys> getAddedList() {
		return (List<Toys>) shopMap.get(shopName);
	}
}
