package kz.epam.main;

import java.util.*;

import kz.epam.factory.Factory;
import kz.epam.shop.Toys;

import java.io.*;
/**
 * <p>Helper for working with file and storing values to the Factory object</p>
 * @author MRSPEC
 * @version 1.0
 */
public class Helper {
	  private Factory factory;
	  private Properties prop;
	  private InputStream input;
	  
	  public Helper() {
		  factory = new Factory();
		  prop = new Properties();
		  input = null;
	  }
	  public Factory readTheFile() {
			try {
				//Reading the file
				String filename = "file.properties";
				input = new FileInputStream(filename);
				if (input == null) {
					System.out.println("Sorry, unable to find " + filename);
					return null;
				}

				prop.load(input);

				Enumeration<?> e = prop.propertyNames();
				while (e.hasMoreElements()) {
					String key = (String) e.nextElement();
					String value = prop.getProperty(key);
					
					//Setting the shop name
					factory.setShopName(key);
					//Splitting by type
					String[] valuesList = value.split(", ");
					for (String values : valuesList) {
						//Splitting by value
						//System.out.println(values);
						String[] typeAndValues = values.split(":");
						typeAndValues[1] = typeAndValues[1].trim();
						String[] valueEach = typeAndValues[1].split(" ");
						
						//Storing values to the factory
						if(typeAndValues[0].equals("Sport")) {
							factory.addSport(valueEach[0], valueEach[1]);
						} else if (typeAndValues[0].equals("Logical")) {
							factory.addLogical(valueEach[0], valueEach[1]);
						}
					}

				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			return factory;

		  }

}
