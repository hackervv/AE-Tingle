package com.tingle.api.h5.service.impl;

import com.tingle.api.h5.service.H5NewsService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/04/22:40
 * @Description:
 */
@RestController
public class H5NewsServiceImpl implements H5NewsService {
    @Override
    public String newsInfo(Long userId) {
        return "Welcome Tingle news System" + userId;
    }
}
