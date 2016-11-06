# crawler
##简单java爬虫，爬取挖财社区理财文章
技术点：webmagic，mysql，mybatis
表结构:
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL default '' COMMENT '标题',
  `url` varchar(200) NOT NULL default '' COMMENT '链接',
  `reply` int(4) NOT NULL default '0' COMMENT '回复数',
  `view` int(4) NOT NULL default '0' COMMENT '浏览数',
  `source` int(4) NOT NULL default '0' COMMENT '来源',
  `url_md5` varchar(100) NOT NULL default '',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uk_url_md5` (`url_md5`),
  KEY `idx_source` (`source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

详情例子

*QQ:823099993
