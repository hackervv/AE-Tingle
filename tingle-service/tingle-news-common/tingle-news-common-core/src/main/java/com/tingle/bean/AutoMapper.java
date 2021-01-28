package com.tingle.bean;

import org.springframework.beans.BeanUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/17:04
 * @Description:
 */
public class AutoMapper<DTO, DO> {
    public static <Do> Do dtoToDo(Object dtoEntity, Class<Do> doClass) {
        if (dtoEntity == null) {
            return null;
        }
        if (doClass == null) {
            return null;
        }
        try {
            Do newInstance = doClass.newInstance();
            BeanUtils.copyProperties(dtoEntity, newInstance);
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static <Dto> Dto doToDto(Object doEntity, Class<Dto> dtoClass) {
        if (doEntity == null) {
            return null;
        }
        if (dtoClass == null) {
            return null;
        }
        try {
            Dto newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }
}
