/**
 * 
 */
package com.uniquemind.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nag
 *
 */
@Entity
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	
	@Column(name = "name")
	private String name;
	
    @Column(name = "email", unique = true, nullable = false)
    private String email;
	
    @Column(name = "mobile", unique = true, nullable = false)
	private int mobile;
	
	public User() {
	}

	public User(int userId, String name, String email, int mobile) {
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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

}
