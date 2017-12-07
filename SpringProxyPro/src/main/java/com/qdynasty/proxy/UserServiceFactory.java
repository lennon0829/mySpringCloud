/**
 * 
 */
package com.qdynasty.proxy;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.qdynasty.service.UserService;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * @author fei.qin
 *
 */
@Configuration
public class UserServiceFactory implements FactoryBean<UserService> {

	private static final Log log = LogFactory.get();

	@Autowired
	private UserService userService;

	@Override
	public UserService getObject() throws Exception {

		return (UserService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] { UserService.class },
				(userService2, method, args) -> {
					log.info("userService=" + userService == null ? "NULL." : "NOT NULL.");
					long startTime = System.currentTimeMillis();
					Object result = method.invoke(userService, args);
					long endTime = System.currentTimeMillis();

					long duration = endTime - startTime;
					log.info("duration=" + duration);

					return result;
				});
	}

	@Override
	public Class<?> getObjectType() {
		return UserService.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
