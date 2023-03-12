package com.fastcampus.projectboard.config;

import com.fastcampus.projectboard.dto.security.BoardPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@EnableJpaAuditing // JPA Auditing 활성화
@Configuration // 설정 클래스를 빈으로 관리
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        // SecurityContextHolder: 시큐리티 인증 정보를 가지고 있는 클래스
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(principal -> (BoardPrincipal) principal)
                .map(BoardPrincipal::getUsername);
    }
}
