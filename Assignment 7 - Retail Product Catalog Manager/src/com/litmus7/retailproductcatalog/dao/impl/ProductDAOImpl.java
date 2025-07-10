package com.litmus7.retailproductcatalog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retailproductcatalog.dao.ProductDAO;
import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.exception.DBConnectionException;
import com.litmus7.retailproductcatalog.exception.ProductDataAccessException;
import com.litmus7.retailproductcatalog.util.DBUtil;
import com.litmus7.retailproductcatalog.constant.SQLQueries;

import static com.litmus7.retailproductcatalog.constant.DBColumns.*;

/**
 * Implementation of {@link ProductDAO} that performs CRUD operations
 * using JDBC to connect to a relational database.
 * 
 * <p>This class interacts with the database via SQL queries defined
 * in {@link SQLQueries}, and handles exceptions by wrapping them in
 * {@link ProductDataAccessException}.
 * 
 * <p>It uses utility class {@link DBUtil} for managing database
 * connections.
 * 
 * @author Muhammed Irfan
 */
public class ProductDAOImpl implements ProductDAO {

    /**
     * Inserts a new {@link Product} into the database.
     *
     * @param product the product to add
     * @return the product that was added
     * @throws ProductDataAccessException if a database error occurs
     */
	@Override
	public Product addProduct(Product product) throws ProductDataAccessException {
		try (Connection connnection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connnection.prepareStatement(SQLQueries.INSERT_PRODUCT,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getCategory());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getStockQuantity());

			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new ProductDataAccessException("Adding product failed, no rows affected.");
			}

			return product;
		} catch (SQLException | DBConnectionException e) {
			throw new ProductDataAccessException("Failed to add product", e);
		}
	}

    /**
     * Retrieves a {@link Product} by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the matching product, or {@code null} if not found
     * @throws ProductDataAccessException if a database error occurs
     */
	@Override
	public Product getProductById(int productId) throws ProductDataAccessException {
	    Product product = null;
	    
	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_PRODUCT_BY_ID)) {

	        preparedStatement.setInt(1, productId);
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
				    product = new Product(
				    	resultSet.getInt(PRODUCT_ID),
				        resultSet.getString(PRODUCT_NAME),
				        resultSet.getString(PRODUCT_CATEGORY),
				        resultSet.getDouble(PRODUCT_PRICE),
				        resultSet.getInt(STOCK_QUANTITY)
				    );
				}
			}
	    } catch (SQLException | DBConnectionException e) {
	        throw new ProductDataAccessException("Failed to fetch product", e);
	    }
	    return product;
	}
	
    /**
     * Retrieves all {@link Product}s from the database.
     *
     * @return a list of all products
     * @throws ProductDataAccessException if a database error occurs
     */
	@Override
	public List<Product> getAllProducts() throws ProductDataAccessException{
	    List<Product> products = new ArrayList<>();

	    try (Connection connection = DBUtil.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(SQLQueries.GET_ALL_PRODUCTS)) {

	        while (resultSet.next()) {
	            Product product = new Product(
            		resultSet.getInt(PRODUCT_ID),
			        resultSet.getString(PRODUCT_NAME),
			        resultSet.getString(PRODUCT_CATEGORY),
			        resultSet.getDouble(PRODUCT_PRICE),
			        resultSet.getInt(STOCK_QUANTITY)
	            );
	            products.add(product);
	        }
	    } catch (SQLException | DBConnectionException e) {
	        throw new ProductDataAccessException("Failed to retrieve products", e);
	    }
	    return products;
	}

    /**
     * Updates an existing {@link Product} in the database.
     *
     * @param product the product with updated values
     * @return the updated product
     * @throws ProductDataAccessException if a database error occurs
     */
	@Override
	public Product updateProduct(Product product) throws ProductDataAccessException {
	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.UPDATE_PRODUCT)) {

	        preparedStatement.setString(1, product.getName());
	        preparedStatement.setString(2, product.getCategory());
	        preparedStatement.setDouble(3, product.getPrice());
	        preparedStatement.setInt(4, product.getStockQuantity());
	        preparedStatement.setInt(5, product.getId());

	        preparedStatement.executeUpdate();
	        
	        return product;
	    } catch (SQLException | DBConnectionException e) {
	        throw new ProductDataAccessException("Failed to update product", e);
	    }
	}

    /**
     * Deletes a {@link Product} by its ID.
     *
     * @param productId the ID of the product to delete
     * @return the ID of the deleted product
     * @throws ProductDataAccessException if a database error occurs
     */
	@Override
	public int deleteProductById(int productId) throws ProductDataAccessException {
	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.DELETE_PRODUCT_BY_ID)) {

	        preparedStatement.setInt(1, productId);
	        preparedStatement.executeUpdate();
	        
	        return productId;
	    } catch (SQLException | DBConnectionException e) {
	        throw new ProductDataAccessException("Failed to delete product", e);
	    }
	}

}
