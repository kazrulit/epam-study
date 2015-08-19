package kz.epam.main;

import java.io.*;
import java.util.*;

import kz.epam.shop.*;
import kz.epam.factory.*;

/**
 * <h1>A software where you can add toys from the factory to one or more shops,
 * by using Template classes, List and ArrayList classes and constructors</h1>
 * @author 		MR_SPEC
 * @version 	1.0
 */

public class main {
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		Sort toys = new Sort();
		Helper helper = new Helper();
		
		factory = helper.readTheFile();
		
		System.out.println("Магазин Технодом:");
		factory.setShopName("Technodom");
		/* Get sorted list by price, and search objects by price*/
		toys.getSortedByAll(factory.getAddedList(), 500);
		
		System.out.println("Магазин Аян:");
		factory.setShopName("Ayan");
		toys.getSortedByAll(factory.getAddedList(), 400);
		
	}

}
