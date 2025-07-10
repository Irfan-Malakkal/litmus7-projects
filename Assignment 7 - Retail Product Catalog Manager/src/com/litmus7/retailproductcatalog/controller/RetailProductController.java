package com.litmus7.retailproductcatalog.controller;

import java.util.List;

import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.service.RetailProductService;
import com.litmus7.retailproductcatalog.dto.Response;
import com.litmus7.retailproductcatalog.exception.RetailProductServiceException;

import static com.litmus7.retailproductcatalog.constant.ResponseConstants.*;
import static com.litmus7.retailproductcatalog.util.ValidationUtil.*;

/**
 * Controller class that handles product-related operations and
 * returns consistent {@link Response} objects to represent outcomes.
 * 
 * <p>This class performs input validation and wraps responses with
 * status codes and messages.
 * 
 * @author Muhammed Irfan
 */
public class RetailProductController {
	private final RetailProductService retailProductService = new RetailProductService();

    /**
     * Adds a new product to the catalog after validation.
     *
     * @param product the product to be added
     * @return a {@link Response} containing the added product or an error message
     */
	public Response<Product> addProduct(Product product) {
		Response<Product> response = new Response<>();
		if (!isProductValid(product)) {
			response.setErrorMessage("Ivalid Input Parameters");
			response.setStatusCode(ERROR_CODE);
		} else {
			try {
				response.setData(retailProductService.addProduct(product));
				response.setStatusCode(SUCCESS_CODE);
			} catch (RetailProductServiceException e) {
				response.setErrorMessage(e.getMessage());
				response.setStatusCode(ERROR_CODE);
			}
		}
		return response;
	}

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product
     * @return a {@link Response} containing the product or an error message
     */
	public Response<Product> getProductById(int productId) {
		Response<Product> response = new Response<>();
		if (productId < 0) {
			response.setErrorMessage("Product Id cannot be less than 0");
			response.setStatusCode(ERROR_CODE);
		} else {
			try {
				response.setData(retailProductService.getProductById(productId));
				response.setStatusCode(SUCCESS_CODE);
			} catch (RetailProductServiceException e) {
				response.setErrorMessage(e.getMessage());
				response.setStatusCode(ERROR_CODE);
			}
		}
		return response;
	}


    /**
     * Retrieves all products from the catalog.
     *
     * @return a {@link Response} containing the list of products or an error message
     */
	public Response<List<Product>> getAllProducts() {
		Response<List<Product>> response = new Response<>();
		try {
			response.setData(retailProductService.getAllProducts());
			response.setStatusCode(SUCCESS_CODE);
		} catch (RetailProductServiceException e) {
			response.setErrorMessage(e.getMessage());
			response.setStatusCode(ERROR_CODE);
		}
		return response;
	}

    /**
     * Updates an existing product after input validation.
     *
     * @param product the updated product details
     * @return a {@link Response} containing the updated product or an error message
     */
	public Response<Product> updateProduct(Product product) {
		Response<Product> response = new Response<>();
		if (!isProductValid(product)) {
			response.setErrorMessage("Invalid Parameters for Updation");
			response.setStatusCode(ERROR_CODE);
		} else {
			try {
				response.setData(retailProductService.updateProduct(product));
				response.setStatusCode(SUCCESS_CODE);
			} catch (RetailProductServiceException e) {
				response.setErrorMessage(e.getMessage());
				response.setStatusCode(ERROR_CODE);
			}
		}
		return response;
	}

    /**
     * Deletes a product by its ID after validating the input.
     *
     * @param productId the ID of the product to delete
     * @return a {@link Response} containing the deleted product ID or an error message
     */
	public Response<Integer> deleteProductById(int productId) {
		Response<Integer> response = new Response<>();
		if (productId < 0) {
			response.setErrorMessage("Product Id cannot be less than 0");
			response.setStatusCode(ERROR_CODE);
		} else {
			try {
				response.setData(retailProductService.deleteProductById(productId));
				response.setStatusCode(SUCCESS_CODE);
			} catch (RetailProductServiceException e) {
				response.setErrorMessage(e.getMessage());
				response.setStatusCode(ERROR_CODE);
			}
		}
		return response;
	}
}
