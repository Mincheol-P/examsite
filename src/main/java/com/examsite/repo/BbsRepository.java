package com.examsite.repo;

import com.examsite.domain.Bbs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BbsRepository extends JpaRepository<Bbs, Long> {
    // 상단고정 여부 우선, 그 다음 수정일순 정렬
    List<Bbs> findAllByOrderByPinnedDescUpdatedAtDesc();
}
