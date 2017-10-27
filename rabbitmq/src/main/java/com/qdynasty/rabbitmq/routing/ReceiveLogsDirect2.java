package com.qdynasty.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

import com.qdynasty.rabbitmq.util.Consts;
import com.qdynasty.rabbitmq.util.RabbitMQ;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
/**
 * 
 * @author fei.qin
 *
 */
public class ReceiveLogsDirect2 implements Callable<Object> {
	private static final Log log = LogFactory.get();

	public void receive() throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException,
			InterruptedException {
		log.info("Received start.");
		RabbitMQ rabbitMQ = new RabbitMQ();
		Channel channel = rabbitMQ.connectionRabbitMQ();
		String queueName = channel.queueDeclare().getQueue();

		channel.queueBind(queueName, Consts.EXCHANGE_NAME, Consts.ROUTING_KEY_ERROR);

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());

			log.info("Received={}", message);
		}
	}
	
	public Object call() throws Exception {
		this.receive();
		return null;
	}

}
