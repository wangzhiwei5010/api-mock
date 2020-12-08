package com.reg.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author wangzhiwei
 */
@Data
@ApiModel("mock数据")
public class BodyData {
    private String type;
    private Object data;
}
