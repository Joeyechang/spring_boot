package com.search.dao;

import com.search.dataBean.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author phoenix
 * @since 2016/11/29
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByTitleContaining(String title);
}
