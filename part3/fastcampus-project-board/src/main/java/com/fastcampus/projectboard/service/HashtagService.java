package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Hashtag;
import com.fastcampus.projectboard.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
@RequiredArgsConstructor
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    // 본문에서 #이 붙은 단어들을 가져오고 해당 단어들을 set 에 담아서 리턴
    public Set<String> parseHashtagNames(String content) {
        if (content == null) {
            return Set.of();
        }

        // 해시태그 정규표현식 Pattern
        Pattern pattern = Pattern.compile("#[\\w가-힣]+");
        Matcher matcher = pattern.matcher(content.strip()); // 앞뒤 공백 제거하고 Matcher 에 저장
        Set<String> result = new HashSet<>();

        // 매칭되는 애들이 있으면 계속 반복
        while (matcher.find()) {
            result.add(matcher.group().replace("#", ""));
        }

        // 불변 Set 으로 반환해서 조금 더 안전하게 사용할 수 있게함
        return Set.copyOf(result);
    }

    public Set<Hashtag> findHashtagsByNames(Set<String> hashtagNames) {
        return new HashSet<>(hashtagRepository.findByHashtagNameIn(hashtagNames));
    }

    public void deleteHashtagWithoutArticles(Long hashtagId) {
        Hashtag hashtag = hashtagRepository.getReferenceById(hashtagId);
        if (hashtag.getArticles().isEmpty()) {
            hashtagRepository.delete(hashtag);
        }
    }
}