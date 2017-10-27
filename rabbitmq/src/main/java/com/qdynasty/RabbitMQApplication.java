package com.qdynasty;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.qdynasty.rabbitmq.routing.Producer;
import com.qdynasty.rabbitmq.routing.ReceiveLogsDirect1;
import com.qdynasty.rabbitmq.routing.ReceiveLogsDirect2;
import com.qdynasty.rabbitmq.thread.ThreadPoolUtil;
import com.qdynasty.rabbitmq.util.ReaderLogFileTask;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
/**
 * 
 * @author fei.qin
 *
 */
public class RabbitMQApplication {
	private static final Log log = LogFactory.get();

	public static void main(String[] args) {

		log.info("RabbitMQApplication start.");

		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

		ReaderLogFileTask logFileTask = new ReaderLogFileTask(queue);

		log.info("RabbitMQApplication logFileTask.");
		ThreadPoolUtil.execute(logFileTask);

		Producer producer = new Producer(queue);
		log.info("RabbitMQApplication logFileTask.");
		ThreadPoolUtil.execute(producer);

		ReceiveLogsDirect1 direct1 = new ReceiveLogsDirect1();
		ReceiveLogsDirect2 direct2 = new ReceiveLogsDirect2();

		log.info("RabbitMQApplication direct.");
		ThreadPoolUtil.execute(direct1);
		ThreadPoolUtil.execute(direct2);

		log.info("RabbitMQApplication end.");
	}
}
