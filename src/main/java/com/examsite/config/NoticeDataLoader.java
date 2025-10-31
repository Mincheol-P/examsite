package com.examsite.config;

import com.examsite.domain.Notice;
import com.examsite.repo.NoticeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoticeDataLoader {

    private final NoticeRepository repo;

    @PostConstruct
    public void init() {
        if (repo.count() == 0) {
            repo.save(new Notice(null, "사이트 오픈 안내", "예시 사이트가 오픈되었습니다.", true));
            repo.save(new Notice(null, "점검 일정 안내", "이번 주 토요일 오전 2시에 서버 점검이 예정되어 있습니다.", false));
            repo.save(new Notice(null, "신규 기능 소개", "공지 게시판의 새 UI를 적용했습니다.", false));
            repo.save(new Notice(null, "문의 방법 안내", "문의사항은 contact@example.com 으로 보내주세요.", false));
            repo.save(new Notice(null, "휴무 공지", "오는 월요일은 내부 사정으로 휴무입니다.", false));
        }
    }
}
