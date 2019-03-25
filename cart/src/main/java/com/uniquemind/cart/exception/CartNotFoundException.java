/**
 * 
 */
package com.uniquemind.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nag
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Order Not Found")
public class CartNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

}
