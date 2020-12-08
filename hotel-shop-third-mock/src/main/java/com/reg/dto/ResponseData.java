package com.reg.dto;

import lombok.Data;

/**
 * @author wangzhiwei
 */
@Data
public class ResponseData<T> {
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 状态码
     */
    private String code;
    /**
     * 数据
     */
    private T data;
}
