package com.search;

import com.search.dao.ArticleRepository;
import com.search.dataBean.Article;
import com.search.dataBean.ArticleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchExerciseApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	public void testAdd() {
        articleRepository.save(ArticleTest.getArticle());
	}

    @Test
    public void testList(){
        Iterable<Article> list = articleRepository.findAll();
        for (Article article : list) {
            System.out.println(article.getContent());
        }
    }

}
