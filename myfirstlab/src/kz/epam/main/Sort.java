package kz.epam.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kz.epam.shop.Toys;
/**
 * <p>Class for Comparing, sorting and searching objects in the given list</p>
 * @author Mr_SPEC
 * @version 1.0
 */
public class Sort implements Comparator<Toys>{

	@Override
	public int compare(Toys e1, Toys e2) {
		if(e1.getPrice() > e2.getPrice()){
			return 0;
		}
		return -1;
	}
	
	/**
	 * <p>Get list sorted and print it on the console</p>
	 * @param list
	 */
	public void getListSorted(List<Toys> list) {
		Collections.sort(list,new Sort());
		System.out.println("Список отсортированных элементов по цене: ");
		for	(Toys e: list) {
			System.out.println(e.toString());
		}	
	}
	
	/**
	 * <p>Search objects that price element equals with the given argument</p>
	 * @param list
	 * @param price
	 */
	public void searchByPrice(List<Toys> list, int price) {
		System.out.println("Список найденых игрушек:");
		for	(Toys e : list) {
			if(e.getPrice() == price) {
				System.out.println("Найденный товар: " + e);
			}
		}
	}
	
	/**
	 * <p>Get list sorted by price, and searched by price</p>
	 * @param list
	 * @param price
	 */
	public void getSortedByAll(List<Toys> list, int price) {
		this.getListSorted(list);
		this.searchByPrice(list, price);
	}
}
