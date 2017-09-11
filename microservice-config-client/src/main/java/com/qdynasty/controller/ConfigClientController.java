/**
 * 
 */
package com.qdynasty.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fei.qin
 *
 */
@RestController
@RefreshScope
public class ConfigClientController {

	//获取Git仓库配置文件中的profile的值
	@Value("${profile}")
	private String profile;

	@GetMapping("/profiles")
	public String hello() {
		return this.profile;
	}
}
