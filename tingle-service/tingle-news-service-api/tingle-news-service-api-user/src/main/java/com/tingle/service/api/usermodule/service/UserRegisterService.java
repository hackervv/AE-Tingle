package com.tingle.service.api.usermodule.service;

import com.alibaba.fastjson.JSONObject;
import com.tingle.api.service.base.BaseResponse;
import com.tingle.service.api.usermodule.dto.req.UserReqRegisterDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/15:36
 * @Description:
 */
@Api(tags = "user register service")
public interface UserRegisterService {

    /**
     * userregister interface
     * @param userReqRegisterDto
     * @return
     */
    @PostMapping("/register")
    BaseResponse<JSONObject> register(@RequestBody UserReqRegisterDto userReqRegisterDto);
}
