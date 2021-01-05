package com.tingle.api.h5.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/04/22:23
 * @Description:
 */
@Api(tags = "new for pc service")
public interface H5NewsService {
    /**
     * H5 Interface
     * @return
     */
    @GetMapping("newsInfo")
    @ApiOperation("appInfo interface")
    @ApiImplicitParam(name = "userId", value = "user's id", required = true)
    @ApiResponse(code = 200, message = "response success")
    String newsInfo(Long userId);
}
