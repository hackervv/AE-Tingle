package com.tingle.api.service.base;

import com.tingle.api.service.constants.Constants;
import lombok.Data;

/**
 * @version V1.0
 * @description: Microservice interface can be implemented by passing parameters,
 *               which can directly encapsulate and unify the returned result set
 * @author: Irek
 * @date: 2021.01.06
 * @Copyright
 */
@Data
public class BaseApiService<T> {

    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * error response ,return error
     *
     * @param msg
     * @return
     */
    public BaseResponse<T> setResultError(String msg) {
        return setResult(Constants.HTTP_RES_CODE_500, msg, null);
    }

    /***
     * success response ,return data
     * @param data
     * @return
     */
    public BaseResponse<T> setResultSuccess(T data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }

    /**
     *  success response without data
     *
     * @return
     */
    public BaseResponse<T> setResultSuccess() {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
    }


    /**
     * Generate
     * @param code
     * @param msg
     * @param data
     * @return
     */

    public BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }

}
