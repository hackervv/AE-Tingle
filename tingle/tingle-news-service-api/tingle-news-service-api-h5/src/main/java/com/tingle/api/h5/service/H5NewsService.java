package com.tingle.api.h5.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/04/22:23
 * @Description:
 */
@RestController
public interface H5NewsService {
    /**
     * H5 Interface
     * @return
     */
    @GetMapping("newsInfo")
    String newsInfo(Long userId);
}
