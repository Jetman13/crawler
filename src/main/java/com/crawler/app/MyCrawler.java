package com.crawler.app;

import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Hello world!
 *
 */
public class MyCrawler extends WebCrawler  
{
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");
	
	@Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
               && href.startsWith("http://www.ics.uci.edu/");
    }

	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
