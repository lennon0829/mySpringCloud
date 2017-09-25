/**
 * 
 */
package com.qdynasty.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @author fei.qin
 *
 */
@Component
public class UserFallbackProvider implements ZuulFallbackProvider {

	/* (non-Javadoc)
	 * @see org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider#fallbackResponse()
	 */
	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("用户微服务不可用，请稍候再试。".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				
				HttpHeaders httpHeaders = new HttpHeaders();
				MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
				
				httpHeaders.setContentType(mt);
				return httpHeaders;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return getStatusCode().value();
			}

			@Override
			public String getStatusText() throws IOException {
				return getStatusCode().getReasonPhrase();
			}

			@Override
			public void close() {
			}
			
		};
	}

	@Override
	public String getRoute() {
		// 表明是为哪个微服务提供回退
		return "microservice-provider-user";
	}

}
