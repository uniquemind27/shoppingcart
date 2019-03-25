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
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User Not Found")
public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

}
