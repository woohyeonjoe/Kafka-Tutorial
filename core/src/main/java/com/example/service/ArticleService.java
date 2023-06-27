package com.example.service;

import com.example.article.Article;
import com.example.producer.CreatedArticleProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final CreatedArticleProducer createdArticleProducer;

    public void addArticle(Long id, String title) {
        Article article = new Article(id, title);
        // 저장 로직
        // 생략

        // 카프카 전송
        createdArticleProducer.createdArticle(article);
    }


}
