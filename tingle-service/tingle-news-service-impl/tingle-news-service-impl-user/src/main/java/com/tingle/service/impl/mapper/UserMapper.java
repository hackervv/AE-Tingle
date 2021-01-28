package com.tingle.service.impl.mapper;

import com.tingle.service.impl.entitydo.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/16:29
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper {
    
    @Insert("INSERT INTO `tingle_user` VALUES (null, #{mobile}, #{passWord},null, '0', '0',now(),'1',  null,null, null);")
    int register(UserDo userDo);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password\n" +
            ",user_name as username ,user_name as username,sex as sex \n" +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE\n" +
            ",\n" +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid\n" +
            "\n" +
            "from tingle_user  where MOBILE=#{mobile}")
    UserDo login(String mobile, String passWord);

    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password\n" +
            ",user_name as username ,user_name as username,sex as sex \n" +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE\n" +
            ",\n" +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid\n" +
            "\n" +
            "from tingle_user  where MOBILE=#{mobile}")
    UserDo existMobile(String mobile);
    @Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE ,password as password\n" +
            ",user_name as username ,user_name as username,sex as sex \n" +
            ",age as age ,create_time as createtime,IS_AVALIBLE as ISAVALIBLE\n" +
            ",\n" +
            "pic_img  as picimg,qq_openid as qqopenid ,wx_openid as wxopenid\n" +
            "\n" +
            "from tingle_user  where USER_ID=#{userId}")
    UserDo findByUser(Long userId);
}
