package com.jetman.webmagic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.selector.Selectable;


public class WaCaiProcessor implements PageProcessor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WaCaiProcessor.class);
	private static int pageNum = 0;
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	public void process(Page page) {
		
		System.out.println(page.getUrl());
		System.out.println(pageNum);
		pageNum++;
		page.addTargetRequests(page.getHtml().links().regex("(https://bbs.wacai\\.com/\\w+/\\w+)").all());
		Selectable a = page.getHtml().xpath("//table[@id='threadlisttableid']/tbody/tr/th/a[@class='s xst']/").$("");
		List<String> titleList = page.getHtml().xpath("//table[@id='threadlisttableid']/tbody/tr/th/a[@class='s xst']/text()").all();
		List<String> urlList = page.getHtml().xpath("//table[@id='threadlisttableid']/tbody/tr/th/a[@class='s xst']/@href").all();
		
        page.putField("title", page.getHtml().xpath("//table[@id='threadlisttableid']/").all());
        page.putField("name", page.getHtml().xpath("//div[@class='container repohead-details-container']/h1/strong/a/text()").toString());
        String name = page.getHtml().xpath("//div[@class='container repohead-details-container']/h1/strong/a/text()").toString();
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']"));
		
	}

	public Site getSite() {
		return site;
	}
	
	public static void main(String[] args) {
		Spider spider = Spider.create(new WaCaiProcessor()).addUrl("http://bbs.wacai.com/forum-16069-1.html").thread(5).
				addPipeline(new JsonFilePipeline("D:\\webmagic\\"));
				spider.setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000))).run();
	}

}
