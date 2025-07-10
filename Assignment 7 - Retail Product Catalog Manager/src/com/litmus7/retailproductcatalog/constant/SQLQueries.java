package com.litmus7.retailproductcatalog.constant;

/**
 * Defines SQL queries for product related database operations.
 */
public class SQLQueries {
	/**
	 * SQL query to insert a new product into the database.
	 * <p>
	 * Expects four parameters: name, category, price, and stock_quantity.
	 * </p>
	 */
	public static final String INSERT_PRODUCT = "INSERT INTO products (product_id, name, category, price, stock_quantity) VALUES (?, ?, ?, ?, ?)";

	/**
	 * SQL query to retrieve a product from the database by id.
	 */
	public static final String GET_PRODUCT_BY_ID = "SELECT product_id, name, category, price, stock_quantity FROM products WHERE product_id = ?";
	
	/**
	 * SQL query to retrieve all products from the database.
	 */
	public static final String GET_ALL_PRODUCTS = "SELECT product_id, name, category, price, stock_quantity FROM products";
	
	/**
	 * SQL query to update product info in the database.
	 */
	public static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, category = ?, price = ?, stock_quantity = ? WHERE product_id = ?";
	
	/**
	 * SQL query to delete product data in the database.
	 */
	public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM products WHERE product_id = ?";
	
}
