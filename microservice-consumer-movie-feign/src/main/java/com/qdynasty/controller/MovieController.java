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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

	@HystrixCommand(fallbackMethod = "findByidFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "1"),
					@HystrixProperty(name = "maxQueueSize", value = "10") })
	@GetMapping("/user/{id}")
	public User findByid(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}

	/**
	 * fallback的入参，必须要和原方法的入参一致
	 * @param id
	 * @return
	 */
	public User findByidFallBack(Long id) {
		LOGGER.info("findByidFallBack start.");

		User user = new User();
		user.setId(-1l);
		user.setName("默认用户");

		return user;
	}
}
