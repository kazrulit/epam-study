package kz.epam.shop;

/**
 * 
 * Abstract Class of Toy shop, that can different type of toys
 * 
 * @author		MR_SPEC
 * @version 	1.0
 *
 */
public abstract class Toys {
	protected int id;
	protected String name;
	protected int price;
	
	/**
	 * <p>Main constructor that may have id, name and price arguments</p>
	 * @param name is the name of the toy
	 * @param price is the price of the toy
	 */
	public Toys(int id, String name, int price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Toys() {
		
	}
	/** Get toy name **/
	public String getName() {
		return name;
	}
	/** Set toy name **/
	public void setName(String name) {
		this.name = name;
	}
	/** Get toy price **/
	public int getPrice() {
		return price;
	}
	/** Set toy price **/
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "id: " + this.id + "Название: " + this.name + "-- Цена: " + this.price;
	}
	
	public int hashCode() {
		return this.id * 31;
	}
}