package com.jetman.webmagic.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
 * 挖财社区文章详情
 * @author Jetman
 *
 */
public class WacaiArticleModel extends BasicArticleModel{
	/**
	 * 回复数
	 */
	private Integer replyNum;
	/**
	 * 浏览数
	 */
	private Integer viewNum;
	public Integer getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
	
}
