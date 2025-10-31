package com.examsite.web;

import com.examsite.domain.Notice;
import com.examsite.repo.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeRepository repo;

    public NoticeController(NoticeRepository repo) {
        this.repo = repo;
    }

    /** 목록 */
    @GetMapping
    public String list(Model m) {
        m.addAttribute("title", "공지사항 리스트 조회");
        m.addAttribute("items", repo.findAllByOrderByPinnedDescUpdatedAtDesc());
        return "notice/list";
    }

    /** 새 공지 폼 */
    @GetMapping("/new")
    public String form(Model m) {
        m.addAttribute("title", "새 공지 생성");
        m.addAttribute("item", new Notice());
        return "notice/form";
    }

    /** 저장 → 목록 */
    @PostMapping
    public String create(Notice n) {
        repo.save(n);
        log.info("Notice created: title='{}', pinned={}", n.getTitle(), n.isPinned());
        return "redirect:/notice";
    }

    /** 보기 전용(detailView) */
    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model m) {
        var item = repo.findById(id).orElseThrow();
        m.addAttribute("title","조회 상세");
        m.addAttribute("item", item);
        return "notice/detailView";
    }

    /** 편집 화면(detail) */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model m) {
        var item = repo.findById(id).orElseThrow();
        m.addAttribute("title", "수정");
        m.addAttribute("item", item);
        return "notice/detail";   // 편집용 템플릿
    }

    /** 수정 저장 → 보기 전용으로 이동 */
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, Notice in) {
        var n = repo.findById(id).orElseThrow();
        n.setTitle(in.getTitle());
        n.setContent(in.getContent());
        n.setPinned(in.isPinned());
        repo.save(n);
        log.info("Notice updated: id={}, title='{}', pinned={}", id, n.getTitle(), n.isPinned());
        // 문자열 연결로 안전하게 리다이렉트
        return "redirect:/notice/" + id + "/view";
    }

    /** 삭제 → 목록 */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        log.info("Notice deleted: id={}", id);
        return "redirect:/notice";
    }
}
