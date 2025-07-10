package com.litmus7.retailproductcatalog.dao;

import java.util.List;

import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.exception.ProductDataAccessException;


/**
 * The {@code ProductDAO} interface provides CRUD operations for managing
 * {@link Product} data in the data store.
 * 
 * <p>It defines methods for adding, retrieving, updating, and deleting products.
 * 
 */
public interface ProductDAO {
	
    /**
     * Adds a new product to the data store.
     *
     * @param product the product to be added
     * @return the added product
     * @throws ProductDataAccessException if a data access error occurs
     */
	Product addProduct(Product product) throws ProductDataAccessException;
	
    /**
     * Retrieves a product by its unique ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the product with the specified ID
     * @throws ProductDataAccessException if the product is not found or a data access error occurs
     */
	Product getProductById(int productId) throws ProductDataAccessException;
	
    /**
     * Retrieves all products from the data store.
     *
     * @return a list of all products
     * @throws ProductDataAccessException if a data access error occurs
     */
	List<Product> getAllProducts() throws ProductDataAccessException;
	
    /**
     * Updates an existing product in the data store.
     *
     * @param product the product with updated data
     * @return the updated product
     * @throws ProductDataAccessException if the update fails or a data access error occurs
     */
	Product updateProduct(Product product) throws ProductDataAccessException;
	
    /**
     * Deletes a product by its unique ID.
     *
     * @param productId the ID of the product to delete
     * @return the id of the deleted product
     * @throws ProductDataAccessException if the deletion fails or a data access error occurs
     */
	int deleteProductById(int productId) throws ProductDataAccessException;
}
