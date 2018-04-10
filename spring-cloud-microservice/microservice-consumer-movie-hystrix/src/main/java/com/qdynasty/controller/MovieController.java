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

import com.qdynasty.entity.User;
import com.qdynasty.feign.UserFeignClient;

/**
 * @author fei.qin
 *
 */
@RestController
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/user/{id}")
	public User findByid(@PathVariable Long id) {
		LOGGER.info("findByid start.");
		return userFeignClient.findById(id);
	}
}
