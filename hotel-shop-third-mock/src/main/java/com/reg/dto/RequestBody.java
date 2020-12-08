package com.reg.dto;

import lombok.Data;

/**
 * @author wangzhiwei
 */
@Data
public class RequestBody<T> {
    /**
     * 合作商的唯一身份标识
     */
    private String appId;
    /**
     * 推荐使用RSA2
     */
    private String signType;
    /**
     * 请求签名
     */
    private String sign;

    private T data;
    private SignResult signResult;

    @Data
    public static class SignResult {
        private boolean check;
    }
}
