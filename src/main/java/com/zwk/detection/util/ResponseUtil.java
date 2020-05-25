package com.zwk.detection.util;

import com.zwk.detection.entity.Response;
import com.zwk.detection.entity.ResponseCode;

public class ResponseUtil {
    public static Response success(Object object){
        Response result = new Response();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMsg(ResponseCode.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Response success(){

        return success(null);
    }

    public static Response empty(){
        Response result = new Response();
        result.setCode(ResponseCode.DATA_IS_EMPTY.getCode());
        result.setMsg(ResponseCode.DATA_IS_EMPTY.getMsg());
        return result;
    }
    /**失败**/
    public static Response error(){
        Response result = new Response();
        result.setCode(ResponseCode.UNKNOWN_ERROR.getCode());
        result.setMsg(ResponseCode.UNKNOWN_ERROR.getMsg());
        return result;
    }
}
