package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외한다.")
@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 게시글 목록 조회")
    @Test
    void givenNothing_whenRequestingArticles_thenReturnsArticleJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles")) // 해당 주소로 GET 요청을 수행했을 때
                .andExpect(status().isOk())  // 응답 상태가 200 인가?
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json"))) // content-type 은 application/hal+json 인가?
                .andDo(print()); // api 호출 결과 출력
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticle_thenReturnsArticleJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1")) // 해당 주소로 GET 요청을 수행했을 때
                .andExpect(status().isOk())  // 응답 상태가 200 인가?
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json"))) // content-type 은 application/hal+json 인가?
                .andDo(print()); // api 호출 결과 출력
    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnsArticleCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1/articleComments")) // 해당 주소로 GET 요청을 수행했을 때
                .andExpect(status().isOk())  // 응답 상태가 200 인가?
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json"))) // content-type 은 application/hal+json 인가?
                .andDo(print()); // api 호출 결과 출력
    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingArticleComments_thenReturnsArticleCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments")) // 해당 주소로 GET 요청을 수행했을 때
                .andExpect(status().isOk())  // 응답 상태가 200 인가?
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json"))) // content-type 은 application/hal+json 인가?
                .andDo(print()); // api 호출 결과 출력
    }

    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNothing_whenRequestingArticleComment_thenReturnsArticleCommentJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments/1")) // 해당 주소로 GET 요청을 수행했을 때
                .andExpect(status().isOk())  // 응답 상태가 200 인가?
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json"))) // content-type 은 application/hal+json 인가?
                .andDo(print()); // api 호출 결과 출력
    }

    @DisplayName("[api] 회원 관련 API 는 일체 제공하지 않는다.")
    @Test
    void givenNothing_whenRequestingUserAccounts_thenThrowsException() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(post("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(put("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(patch("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(delete("/api/userAccounts")).andExpect(status().isNotFound());
        mvc.perform(head("/api/userAccounts")).andExpect(status().isNotFound());
    }
}
