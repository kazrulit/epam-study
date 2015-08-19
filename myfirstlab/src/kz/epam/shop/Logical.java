package kz.epam.shop;

import kz.epam.shop.interfaces.LogicalInterface;

/**
 * <p>Extended class of Toys, where you can also set minimum age to the objects 
 * with different types</p>
 * @author MRSPEC
 *
 */
public class Logical extends Toys implements LogicalInterface {
	private int minAge = 3;
	public Logical(int id, String name, int price){
		super(id, name, price);
	}
	
	/** 
	 * <p>Setting custom minimum age for the given toy, default minimum age is 3 years old</p>
	 * @param w, that is value for minimum age and can be any of these types: integer, string or long 
	 * **/
	public void setMinAge(int w) {
		this.minAge = w;
	}
	
	public void setMinAge(String w) {
		this.minAge = Integer.valueOf(w);
	}
	
	public void setMinAge(long w) {
		this.minAge = (int) w;
	}
	
	/** Getting minimum age for the toy **/
	public int getMinAge() {
		return this.minAge;
	}
	
	public String toString(){
		return "id: " + this.id + ", Тип: логические головоломки, "
				+ "Название: " + this.name
				+ "-- Цена: " + this.price;
	}
	
	public int hashCode() {
		return this.id * 31;
	}
}