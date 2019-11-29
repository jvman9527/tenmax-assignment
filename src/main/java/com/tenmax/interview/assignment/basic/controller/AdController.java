package com.tenmax.interview.assignment.basic.controller;

import com.tenmax.interview.assignment.basic.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TenMax 廣告 API
 */
@RestController
public class AdController {

    @Autowired
    private AdRepository adRepository;

    /**
     * 預設回傳 Ad 表中的所有資料列
     * 若指定非空白的 title 參數，執行 %title% 的模糊搜尋
     * 使用 Spring 分頁支援 預設搜尋結果每頁 100 筆資料
     * @param title
     * @param pageable
     */
    @RequestMapping("/ad")
    public Object find(
        @RequestParam(required = false) String title,
        @PageableDefault(size = 100) Pageable pageable
    ) {
        if (title != null && !title.isEmpty()) {
            return adRepository.findByTitleContaining(title, pageable)
                                .getContent();
        }

        return adRepository.findAll(pageable)
                            .getContent();
    }

}

