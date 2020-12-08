package com.reg.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author wangzhiwei
 */
@Data
@ApiModel("mock-Key数据")
public class KeyData {
    private String appId;
    private String data;
}
