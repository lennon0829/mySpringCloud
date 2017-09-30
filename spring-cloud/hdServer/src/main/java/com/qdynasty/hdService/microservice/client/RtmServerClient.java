/**
 * 
 */
package com.qdynasty.hdService.microservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qdynasty.hdService.microservice.client.fallback.RtmServiceFallBack;

/**
 * @author fei.qin
 *
 */
@FeignClient(name = "rtmService", fallback = RtmServiceFallBack.class)
public interface RtmServerClient {

	/**
	 * 1.feign中只能使用@RequestMapping，然后指定method
	 * 2.如果通过url传递参数，则再方法中必须要用@PathVariable 修饰该参数,示例：@PathVariable("id") Long id；
	 * 	 如果通过方法传递参数，则必须要用@RequestParam 修改该参数，示例：@RequestParam("billingCode") String billingCode
	 */
	@RequestMapping(value = "/conference/loadConferenceByBillingCode", method = RequestMethod.GET)	
	public String loadConferenceByBillingCode(@RequestParam("billingCode") String billingCode);
}
