package com.jetman.webmagic.pipeline;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.jetman.webmagic.dao.ArticleDao;
import com.jetman.webmagic.model.WacaiArticleModel;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("articlePipeline")
public class ArticlePipeline implements Pipeline {


//    public void process(WacaiArticleModel wacaiArticleModel, Task task) {
//    	articleDao.add(wacaiArticleModel);
//    }

	public void process(ResultItems resultItems, Task task) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final ArticleDao articleDao = applicationContext.getBean(ArticleDao.class);
		
		Map<String, Object> result = resultItems.getAll();
		List<WacaiArticleModel> list = (List<WacaiArticleModel>) result.get("articleList");
		
		System.err.println("*************保存结果"+list==null?0:list.size());
		if(CollectionUtils.isNotEmpty(list)) {
			for (WacaiArticleModel wacaiArticleModel : list) {
				articleDao.add(wacaiArticleModel);
			}
		}
		
	}
}

