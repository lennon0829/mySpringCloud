/**
 * 
 */
package com.qdynasty.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	/**
	 * #服务的虚拟主机名,Ribbon会将虚拟主机名转换为微服务的网络地址
	 */
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/user/{id}")
	public User findByid(@PathVariable Long id) {
		return restTemplate.getForObject(userServiceUrl + id, User.class);
	}
	
	/**
	 * 负载均衡选择的服务:microservice-provider-user其中一个实例信息
	 * @return
	 */
	@GetMapping("log-instance")
	public ServiceInstance logUserInstance()
	{
		ServiceInstance instance = this.loadBalancerClient.choose("microservice-provider-user");
		LOGGER.info("{}:{}:{}", instance.getServiceId(), instance.getHost(), instance.getPort());
		
		return instance;
	}
	
	/**
	 * 微服务：microservice-provider-user 的所有实例列表信息
	 * @return
	 */
	@GetMapping("/user-instance")
	public List<ServiceInstance> showMetaDataInfo() {
		
		return this.discoveryClient.getInstances("microservice-provider-user");
	}
}
