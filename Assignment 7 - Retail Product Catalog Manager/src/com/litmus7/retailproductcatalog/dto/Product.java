package com.litmus7.retailproductcatalog.dto;

/**
 * Represents a product in the system with basic information. This class
 * is used to transfer user data between layers such as controller, service, and
 * DAO.
 * 
 * <p>
 * It includes fields for id, name, category, price and stockQuantity, along with
 * appropriate getters and setters.
 * </p>
 * 
 * <p>
 * This class overrides {@code toString()} to provide a formatted display of
 * product details.
 * </p>
 * 
 * @author Muhammed Irfan
 */
public class Product {

	private int id;
	private String name;
	private String category;
	private double price;
	private int stockQuantity;
	
	public Product(int id, String name, String category, double price, int stockQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	/**
	 * Get the id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the Name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Category
	 * 
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the Category
	 * 
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Get the Price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the Price
	 * 
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the Stock
	 * 
	 * @return the stockQuantity
	 */
	public int getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * Set the Stock
	 * 
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	/**
	 * Override the toString method to display the Product details
	 */
	@Override
	public String toString() {
		return "ID: " + id + " | Name: " + name + " | Category: " + category + " | Price: " + price
				+ " | StockQuantity: " + stockQuantity;
	}
	
}
