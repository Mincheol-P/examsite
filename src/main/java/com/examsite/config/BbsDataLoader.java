package com.examsite.config;

import com.examsite.domain.Bbs;
import com.examsite.repo.BbsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BbsDataLoader {

    private final BbsRepository repo;

    @PostConstruct
    public void init() {
        if (repo.count() == 0) {
            repo.save(new Bbs(null, "첫 번째 게시글", "이곳은 예시 게시판입니다. 자유롭게 테스트하세요.", true));
            repo.save(new Bbs(null, "프로젝트 진행 공지", "현재 테스트 중인 사이트의 게시판입니다.", false));
            repo.save(new Bbs(null, "문의 테스트", "이 글은 단순 예시 데이터입니다.", false));
            repo.save(new Bbs(null, "사용법 안내", "게시글 작성, 수정, 삭제 기능이 모두 정상 동작합니다.", false));
            repo.save(new Bbs(null, "마지막 샘플 글", "데이터베이스가 비어 있을 때 자동으로 생성됩니다.", false));
        }
    }
}
