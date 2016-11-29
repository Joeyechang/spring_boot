package com.search.dataBean;

import org.junit.Test;

/**
 * Created by mike on 2016/11/29.
 */
public class ArticleTest {
    public static Article getArticle(){
        return  Article.builder()
                       .id(1)
                       .sid("10086")
                       .title("elasticsearch")
                       .url("baidu.com")
                       .content("elasticsearch spring boot java")
                       .build();
    }
    @Test
    public void testGetArticle(){
        System.out.println(getArticle());
    }
}
