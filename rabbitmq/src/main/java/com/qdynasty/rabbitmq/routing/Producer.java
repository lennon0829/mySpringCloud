package com.qdynasty.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import com.qdynasty.rabbitmq.util.Consts;
import com.qdynasty.rabbitmq.util.RabbitMQ;
import com.rabbitmq.client.Channel;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
/**
 * 
 * @author fei.qin
 *
 */
public class Producer implements Callable<Object> {

	private BlockingQueue<String> queue = null;

	private static final Log log = LogFactory.get();

	public Producer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	public void sendLogToRabbitMQ(Channel channel) {
		log.info("sendLogToRabbitMQ start.");
		try {

			if (queue == null) {
				log.info("queue is empty.");
				return;
			}

			while (true) {
				String logMessage = queue.take();

				for (int i = 0; i < Consts.ROUTING_KEYS.length; i++) {
					String logLevel = Consts.ROUTING_KEYS[i];
					channel.basicPublish(Consts.EXCHANGE_NAME, logLevel, null, logMessage.getBytes());
				}
			}
		} catch (InterruptedException e) {
			log.error("has InterruptedException:", e);
		} catch (IOException e) {
			log.error("has IOException:", e);
		}
	}

	public Object call() throws Exception {
		RabbitMQ rabbitMQ = new RabbitMQ();
		Channel channel = rabbitMQ.connectionRabbitMQ();
		sendLogToRabbitMQ(channel);
		return null;
	}
}
