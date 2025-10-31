package com.examsite.web;

import com.examsite.domain.Bbs;
import com.examsite.repo.BbsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/bbs")
public class BbsController {

    private final BbsRepository repo;
    public BbsController(BbsRepository repo) { this.repo = repo; }

    // 목록
    @GetMapping
    public String list(Model m) {
        m.addAttribute("title", "게시판");
        m.addAttribute("items", repo.findAllByOrderByPinnedDescUpdatedAtDesc());
        return "bbs/list";
    }

    // 새 글 폼
    @GetMapping("/new")
    public String form(Model m) {
        m.addAttribute("title", "게시글 작성");
        m.addAttribute("item", new Bbs());
        return "bbs/form";
    }

    // 저장 → 목록
    @PostMapping
    public String create(Bbs b) {
        repo.save(b);
        return "redirect:/bbs";
    }

    // 보기 전용(detailView)
    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model m){
        m.addAttribute("title","게시글 상세");
        m.addAttribute("item", repo.findById(id).orElseThrow());
        return "bbs/detailView";
    }

    // 편집 화면(detail)
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model m) {
        m.addAttribute("title", "게시글 수정");
        m.addAttribute("item", repo.findById(id).orElseThrow());
        return "bbs/detail";   // 편집용 템플릿
    }

    // 수정 저장 → 보기 전용으로 이동
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, Bbs in) {
        var b = repo.findById(id).orElseThrow();
        b.setTitle(in.getTitle());
        b.setContent(in.getContent());
        b.setPinned(in.isPinned());
        repo.save(b);
        return "redirect:/bbs/" + id + "/view";
    }

    // 삭제 → 목록
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/bbs";
    }
}
