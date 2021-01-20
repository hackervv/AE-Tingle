package com.tingle.service.api.usermodule.service;

import com.tingle.api.service.base.BaseResponse;
import com.tingle.service.api.usermodule.dto.resp.UserRespDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/22:15
 * @Description:
 */
@Api(tags = "User Info service")
public interface UserInfoService {
    @GetMapping("getUserByToken")
    BaseResponse<UserRespDto> getUserByToken(@RequestParam("token") String token);
}
