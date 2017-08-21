/**
 * 
 */
package com.qdynasty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		LOGGER.info("[microservice-provider-user-nosecurity] findById start.");
		return this.userRepository.findOne(id);
	}
}