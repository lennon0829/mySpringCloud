/**
 * 
 */
package com.qdynasty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qdynasty.dao.UserRepository;
import com.qdynasty.entity.User;

/**
 * @author fei.qin
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}
}
