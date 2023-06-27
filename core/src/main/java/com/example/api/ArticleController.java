package com.example.api;

import com.example.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/articles")
    private ResponseEntity<Void> addArticle(@RequestBody ArticleRequest request) {
        articleService.addArticle(request.getId(), request.getTitle());
        return ResponseEntity.noContent().build();
    }
}
