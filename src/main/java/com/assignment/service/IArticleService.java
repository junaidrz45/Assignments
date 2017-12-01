package com.assignment.service;

import java.util.List;

import com.assignment.entity.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int brandsId);
     boolean addArticle(Article brands);
     void updateArticle(Article brands);
     void deleteArticle(int brandsId);
}
