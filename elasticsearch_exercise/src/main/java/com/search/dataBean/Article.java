package com.search.dataBean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author phoenix
 * @since 2016/11/29
 */
@Document(indexName = "searchBook", type = "article")
public class Article {

    @Id
    @Field(type = FieldType.Integer, index = FieldIndex.not_analyzed, store = true)
    private Integer id;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String sid;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String title;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String url;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String content;
}
