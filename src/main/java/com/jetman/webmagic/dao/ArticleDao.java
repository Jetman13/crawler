package com.jetman.webmagic.dao;

import com.jetman.webmagic.model.WacaiArticleModel;
import org.apache.ibatis.annotations.Insert;
public interface  ArticleDao {
	
	@Insert("insert into t_article (`title`,`url`,`reply`,`view`,`source`,`url_md5`,`create_time`,`update_time`) values (#{title},#{url},#{replyNum},#{viewNum},#{source},#{urlMd5},now(),now()) ON DUPLICATE KEY UPDATE "
			+ "title=#{title},reply=#{replyNum},view=#{viewNum},source=#{source},update_time=now()")
    public int add(WacaiArticleModel article);

}
