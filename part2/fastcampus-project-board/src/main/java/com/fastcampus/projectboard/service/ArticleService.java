package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType type, String keyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(Long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
//        Article article = Article.of(dto.title(), dto.content(), dto.hashtag());
//        articleRepository.save(article);
    }

    public void updateArticle(Long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(Long articleId) {
    }
}
