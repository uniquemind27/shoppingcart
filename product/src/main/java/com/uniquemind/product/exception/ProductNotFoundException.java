/**
 * 
 */
package com.uniquemind.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nag
 *
 */
@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "Product not found")
public class ProductNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

}
