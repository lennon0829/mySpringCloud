/**
 * 
 */
package com.qdynasty.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qdynasty.entity.User;

/**
 * fallbackFactory: feign与hystrix整合，也可以使用fallback，但是不能获取fallback原因。
 * 但是fallbackFactory的灵活性在于可以根据fallback的原因，返回不同的内容。
 * @author fei.qin
 *
 */
@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

	/**
	 * 注解里的地址，是服务提供者的REST接口。也就是microservice-provider-user服务中将要被调用的接口
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}