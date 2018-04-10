/**
 * 
 */
package com.qdynasty.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qdynasty.entity.User;

import feign.hystrix.FallbackFactory;

/**
 * @author fei.qin
 *
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {

			@Override
			public User findById(Long id) {

				LOGGER.info("fallback; reason was:" + cause);
				
				User user = new User();
				user.setId(-1l);
				user.setName("默认用户");
				return user;
			}
		};
	}
}
