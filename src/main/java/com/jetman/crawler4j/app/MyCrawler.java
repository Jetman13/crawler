package com.jetman.crawler4j.app;

import java.util.Set;
import java.util.regex.Pattern;

import org.apache.http.Header;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
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
               ;
    }
	
	@Override
    public void visit(Page page) {
		  int docid = page.getWebURL().getDocid();
		    String url = page.getWebURL().getURL();
		    String domain = page.getWebURL().getDomain();
		    String path = page.getWebURL().getPath();
		    String subDomain = page.getWebURL().getSubDomain();
		    String parentUrl = page.getWebURL().getParentUrl();
		    String anchor = page.getWebURL().getAnchor();

		    logger.debug("Docid: {}", docid);
		    logger.info("URL: {}", url);
		    logger.debug("Domain: '{}'", domain);
		    logger.debug("Sub-domain: '{}'", subDomain);
		    logger.debug("Path: '{}'", path);
		    logger.debug("Parent page: {}", parentUrl);
		    logger.debug("Anchor text: {}", anchor);

		    if (page.getParseData() instanceof HtmlParseData) {
		      HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
		      String text = htmlParseData.getText();
		      String html = htmlParseData.getHtml();
		      Set<WebURL> links = htmlParseData.getOutgoingUrls();

		      logger.debug("Text length: {}", text.length());
		      logger.debug("Html length: {}", html.length());
		      logger.debug("Number of outgoing links: {}", links.size());
		    }

		    Header[] responseHeaders = page.getFetchResponseHeaders();
		    if (responseHeaders != null) {
		      logger.debug("Response headers:");
		      for (Header header : responseHeaders) {
		        logger.debug("\t{}: {}", header.getName(), header.getValue());
		      }
		    }

		    logger.debug("=============");
   }

	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
