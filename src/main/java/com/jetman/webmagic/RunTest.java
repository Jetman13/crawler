package com.jetman.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

public class RunTest {
	
	public static void main(String[] args) {
		
		Spider.create(new GitHubProcessor()).addUrl("https://github.com/Jetman13/crawler").thread(5)
		.addPipeline(new JsonFilePipeline("D:\\webmagic")).run();
	}

}
