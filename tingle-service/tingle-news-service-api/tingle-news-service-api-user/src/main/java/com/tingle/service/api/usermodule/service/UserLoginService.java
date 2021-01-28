package com.tingle.service.api.usermodule.service;

import com.alibaba.fastjson.JSONObject;
import com.tingle.api.service.base.BaseResponse;
import com.tingle.service.api.usermodule.dto.req.UserLoginDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/20:28
 * @Description:
 */
@Api(tags = "user login service")
public interface UserLoginService {
    @PostMapping(value = "/login")
    BaseResponse<JSONObject> login(@RequestBody UserLoginDto userLoginDto);
}
