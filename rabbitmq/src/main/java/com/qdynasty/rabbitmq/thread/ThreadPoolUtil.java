package com.qdynasty.rabbitmq.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.xiaoleilu.hutool.util.ThreadUtil;
/**
 * 
 * @author fei.qin
 *
 */
public class ThreadPoolUtil {

	private static ExecutorService executorService = null;

	private static void threadPoolInstance() {

		if (executorService != null) {
			return;
		}

		executorService = ThreadUtil.newExecutor(2, 10);
	}

	public static <T> Future<T> execute(Callable<T> task) {
		threadPoolInstance();
		return executorService.submit(task);
	}
}
