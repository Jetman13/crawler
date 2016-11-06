package com.jetman.webmagic.model;
/**
 * 文章基础model
 * @author Jetman
 *
 */
public class BasicArticleModel {
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 链接
	 */
	private String url;
	/**
	 * 来源
	 */
	private Integer source;
	/**
	 * urlmd5
	 */
	private String urlMd5;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public String getUrlMd5() {
		return urlMd5;
	}
	public void setUrlMd5(String urlMd5) {
		this.urlMd5 = urlMd5;
	}


}
