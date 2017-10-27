package com.qdynasty.rabbitmq.util;
/**
 * 
 * @author fei.qin
 *
 */
public class Consts {
	public static final String EXCHANGE_NAME = "direct_logs";

	public static final String[] ROUTING_KEYS = new String[] { "INFO", "ERROR" };

	public static final String ROUTING_KEY_INFO = "INFO";

	public static final String ROUTING_KEY_ERROR = "ERROR";

	public static final String LOG_FILE_PATH = "D:\\156\\p\\acm.log.2017-09-26\\home\\log_backup\\acm.log.2017-09-26";
}
