/**
 * 
 */
package com.uniquemind.order.model;

/**
 * @author Nag
 *
 */
public class User {
	
	private int userId;
	
	private String name;
	
    private String email;
	
	private String mobile;
	
	public User() {
	}

	public User(int userId, String name, String email, String mobile) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
