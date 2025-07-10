package com.litmus7.retailproductcatalog.util;

import com.litmus7.retailproductcatalog.dto.Product;

/**
 * Utility class providing validation methods for product input fields such as
 * id, name, category, price and stock quantity.
 */
public class ValidationUtil {
	/**
	 * Validates the product object
	 * 
	 * @param product the product object
	 * @return {@code true} if the product satisfies the conditions; {@code false}
	 *         otherwise
	 */
	public static boolean isProductValid(Product product) {
		return product != null && product.getId() > 0 && !product.getName().isEmpty()
				&& !product.getCategory().isEmpty() && product.getPrice() > 0 && product.getStockQuantity() >= 1;
	}
}
