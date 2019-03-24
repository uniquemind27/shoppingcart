/**
 * 
 */
package com.uniquemind.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniquemind.user.model.User;

/**
 * @author Nag
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
