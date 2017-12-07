/**
 * 
 */
package com.qdynasty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qdynasty.proxy.UserServiceFactory;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * @author fei.qin
 *
 */
@RestController
@RequestMapping(value = "/userController")
public class UserController {

	private static final Log log = LogFactory.get();

	@Autowired
	private UserServiceFactory userServiceFactory;

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String user() {
		log.info("[UserController] user start.");
		String user = "this is test.";
		try {
			user = userServiceFactory.getObject().queryUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return user;
	}

}
