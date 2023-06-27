package com.example.consumer;

import com.example.article.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatedArticleAnalysisConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "add_article", groupId = "analysis")
    public void createdArticleEvent(String jsonObject) {
        try{
            Article article = objectMapper.readValue(jsonObject, Article.class);
            Long id = article.getId();
            System.out.println("Analysis :" + id);  // 저장하는 로직
        } catch(Exception e) {
            // 실패에 대한 로직처리
        }
    }


}
