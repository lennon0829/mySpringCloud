/**
 * 
 */
package com.qdynasty.service.impl;

import org.springframework.stereotype.Component;

import com.qdynasty.service.UserService;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * @author fei.qin
 *
 */
@Component
public class UserServiceImpl implements UserService {

	private static final Log log = LogFactory.get();

	public String queryUser() {

		log.info("[UserServiceImpl] queryUser start.");

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			log.error("[UserServiceImpl] queryUser has exception.");
		}
		log.info("[UserServiceImpl] queryUser end.");
		return "this is a real test.";
	}
}
