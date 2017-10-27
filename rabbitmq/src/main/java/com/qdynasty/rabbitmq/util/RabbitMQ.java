package com.qdynasty.rabbitmq.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
/**
 * 
 * @author fei.qin
 *
 */
public class RabbitMQ {

	private static final Log log = LogFactory.get();

	public Channel connectionRabbitMQ() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("admin");
		factory.setPassword("admin");
		factory.setHost("127.0.0.1");

		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();
		// ÉùÃ÷½»»»»ú
		channel.exchangeDeclare(Consts.EXCHANGE_NAME, "direct");

		return channel;
	}

	public void close(Channel channel) {
		Connection connection = channel.getConnection();

		try {
			channel.close();
		} catch (IOException e) {
			log.error(e);
		} catch (TimeoutException e) {
			log.error(e);
		} finally {
			try {
				connection.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}
}
