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
@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Server Error")
public class CartAddFailureException extends Exception {

	private static final long serialVersionUID = 1L;
}
