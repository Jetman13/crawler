package com.jetman.crawler.common;

public class Config {
	
	public static String path = "E://crawlerdown";
	
	static {
		System.out.println("file separator = "+java.io.File.separator);
		if (java.io.File.separator.equals("/")) {
			path = "/home/jetman/crawlerdown";
		}
	}

}
