package com.example.producer;

import com.example.article.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatedArticleProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void createdArticle(Article article) {
        try {
            String jsonObject = objectMapper.writeValueAsString(article);      //json 변환
            kafkaTemplate.send("add_article", jsonObject);  // Kafka 에 전송
        } catch (Exception e) {
            // 카프카 전송 실패 로직
        }
    }


}
