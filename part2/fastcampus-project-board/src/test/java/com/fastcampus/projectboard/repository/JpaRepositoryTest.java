package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.config.JpaConfig;
import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.UserAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    private final UserAccountRepository userAccountRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository,
            @Autowired UserAccountRepository userAccountRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void selectTest() {
        List<Article> articles = articleRepository.findAll();
        assertThat(articles).isNotNull().hasSize(123);
    }

    @DisplayName("insert 테스트")
    @Test
    void insertTest() {
        long previousCount = articleRepository.count();

        UserAccount userAccount = userAccountRepository.save(UserAccount.of("dongmin", "pw", null, null, null));
        Article article = Article.of(userAccount, "new article", "new content", "#spring");

        articleRepository.save(article);

        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void updateTest() {
        Article article = articleRepository.findById(1L).orElseThrow();
        article.setHashtag("#springboot");

        articleRepository.flush();

        assertThat(article).hasFieldOrPropertyWithValue("hashtag", "#springboot");
    }

    @DisplayName("delete 테스트")
    @Test
    void deleteTest() {
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousCount = articleRepository.count();
        long previousCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();

        articleRepository.delete(article);

        assertThat(articleRepository.count()).isEqualTo(previousCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousCommentCount - deletedCommentsSize);
    }
}
