/**
 * 
 */
package com.qdynasty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/user/{id}")
	public User findByid(@PathVariable Long id) {
		System.out.println("user.userServiceUrl=" + userServiceUrl);
		
		return restTemplate.getForObject(userServiceUrl + id, User.class);
	}
}
