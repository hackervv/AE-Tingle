package com.tingle.service.impl.usermodule;

import com.alibaba.fastjson.JSONObject;
import com.tingle.api.service.base.BaseApiService;
import com.tingle.api.service.base.BaseResponse;
import com.tingle.service.api.usermodule.dto.req.UserLoginDto;
import com.tingle.service.api.usermodule.service.UserLoginService;
import com.tingle.service.impl.entitydo.UserDo;
import com.tingle.service.impl.mapper.UserMapper;
import com.tingle.utils.MD5Util;
import com.tingle.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/19/20:27
 * @Description:
 */
@RestController
public class UserLoginServiceImpl extends BaseApiService implements UserLoginService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private TokenUtils tokenUtils;
    
    @Value("${tingle.login.token.prefix}")
    private String userLoginTokenFix;
    
    @Override
    public BaseResponse<JSONObject> login(UserLoginDto userLoginDto) {
        //Parameter validation
        String mobile = userLoginDto.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号不能为空");
        }
        String passWord = userLoginDto.getPassword();
        if (StringUtils.isEmpty(passWord)) {
            return setResultError("密码不能为空");
        }
        
        String newPassWord = MD5Util.MD5(passWord);
        UserDo userLoginDo = userMapper.login(mobile, newPassWord);
        if (userLoginDo == null) {
            return setResultError("手机号码或者密码不正确！");
        }
        Long userId = userLoginDo.getUserId();
        String userToken = tokenUtils.createToken(userLoginTokenFix, userId + "", 30 * 60 * 1000L);
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("userToken", userToken);
        return setResultSuccess(resultJSON);
    }
}
