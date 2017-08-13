/**
 * 
 */
package com.qdynasty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qdynasty.entity.User;

/**
 * @author fei.qin
 *
 */
@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/user/{id}")
	public User findByid(@PathVariable Long id) {
		return restTemplate.getForObject("http://127.0.0.1:8000/" + id, User.class);
	}
}
