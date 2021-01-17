package com.tingle.service.impl.usermodule;

import com.alibaba.fastjson.JSONObject;
import com.tingle.api.service.MD5Util;
import com.tingle.api.service.base.BaseApiService;
import com.tingle.api.service.base.BaseResponse;
import com.tingle.service.api.usermodule.dto.req.UserReqRegisterDto;
import com.tingle.service.api.usermodule.service.UserRegisterService;
import com.tingle.service.impl.entitydo.UserDo;
import com.tingle.service.impl.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/16:23
 * @Description:
 */
@RestController
public class UserRegisterServiceImpl extends BaseApiService implements UserRegisterService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public BaseResponse<JSONObject> register(UserReqRegisterDto userReqRegisterDto) {
        //Parameter validation
        String mobile = userReqRegisterDto.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号不能为空");
        }
        String passWord = userReqRegisterDto.getPassWord();
        if (StringUtils.isEmpty(passWord)) {
            return setResultError("密码不能为空");
        }
        UserDo userDbDo = userMapper.existMobile(mobile);
        if (userDbDo != null) {
            return setResultError("该手机号码已经存在");
        }
        UserDo userDo = (UserDo) dtoToDo(userReqRegisterDto, UserDo.class);
        String newPassWord = MD5Util.MD5(passWord);
        userDo.setPassWord(newPassWord);
        int register = userMapper.register(userDo);
        return setResult(register, "注册成功", "注册失败");
    }
}
