package kz.epam.shop;

import kz.epam.shop.interfaces.SportInterface;

/**
 * <p>Extended class of Toys, where you can also set warranty to the objects 
 * with different types</p>
 * @author MRSPEC
 *
 */
public class Sport extends Toys implements SportInterface {
	/** Warranty, by default is 1 year **/
	private int warranty = 1;
	
	public Sport(int id, String name, int price) {
		super(id, name, price);
	}
	
	public Sport() {
		super();
	}
	/** Setting custom warranty for the toy, default warranty is 1 year 
	 *  @param w, that is Warranty and can be any of these types: integer, string or long 
	 * **/
	public void setWarranty(int w) {
		this.warranty = w;
	}
	
	public void setWarranty(String w) {
		this.warranty = Integer.valueOf(w);
	}
	
	public void setWarranty(long w) {
		this.warranty = (int) w;
	}
	/** Getting warranty of the toy **/
	public int getWarranty() {
		return this.warranty;
	}
	
	public String toString() {
		return "id: " + this.id + ", "
				+ "Тип: спортивный, "
				+ "Название: " + this.name 
				+ "-- Цена: " + this.price + ", "
				+ "Гарантия: " + warranty + " год";
	}
	
	public int hashCode() {
		return this.id * 31;
	}
}
