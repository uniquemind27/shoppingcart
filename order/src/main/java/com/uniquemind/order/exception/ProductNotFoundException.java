/**
 * 
 */
package com.uniquemind.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nag
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Product Not Found")
public class ProductNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

}
