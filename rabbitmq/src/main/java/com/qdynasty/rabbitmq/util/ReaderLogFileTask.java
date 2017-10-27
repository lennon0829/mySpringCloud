package com.qdynasty.rabbitmq.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import com.xiaoleilu.hutool.io.LineHandler;
import com.xiaoleilu.hutool.io.file.FileReader;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.util.StrUtil;
/**
 * 
 * @author fei.qin
 *
 */
public class ReaderLogFileTask implements Callable<Object> {

	private BlockingQueue<String> queue = null;

	private static final Log log = LogFactory.get();

	public ReaderLogFileTask(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	public Object call() throws Exception {

		log.info("start to ready local log file.");
		FileReader fileReader = new FileReader(Consts.LOG_FILE_PATH);
		LogLineHandler logLineHandler = new LogLineHandler();
		logLineHandler.setQueue(queue);
		fileReader.readLines(logLineHandler);

		return null;
	}
}

class LogLineHandler implements LineHandler {

	private BlockingQueue<String> queue = null;

	private Log log = LogFactory.get();

	public void handle(String line) {
		if (queue == null || StrUtil.isEmpty(line)) {
			return;
		}
		try {
			log.info("logline={}", line);
			queue.put(line);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public BlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<String> queue) {
		this.queue = queue;
	}
}
