package com.tingle.service.impl.usermodule;

import com.tingle.api.service.base.BaseApiService;
import com.tingle.api.service.base.BaseResponse;
import com.tingle.service.api.usermodule.dto.resp.UserRespDto;
import com.tingle.service.api.usermodule.service.UserInfoService;
import com.tingle.service.impl.entitydo.UserDo;
import com.tingle.service.impl.mapper.UserMapper;
import com.tingle.utils.DesensitizationUtil;
import com.tingle.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/22:21
 * @Description:
 */
@RestController
public class UserInfoServiceImpl extends BaseApiService implements UserInfoService {
    
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public BaseResponse<UserRespDto> getUserByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return setResultError("token不能为空");
        }
        String userId = tokenUtils.getTokenValue(token);
        UserDo userInfo = userMapper.findByUser(Long.parseLong(userId));
        if (StringUtils.isEmpty(userId)) {
            return setResultError("无效token");
        }
        if (userInfo == null) {
            return setResultError("无效用户");
        }
        UserRespDto userRespDto = (UserRespDto) dtoToDo(userInfo, UserRespDto.class);
        String mobile = userRespDto.getMobile();
        userRespDto.setMobile(DesensitizationUtil.mobileEncrypt(mobile));
        return setResultSuccess(userRespDto);
    }
}
