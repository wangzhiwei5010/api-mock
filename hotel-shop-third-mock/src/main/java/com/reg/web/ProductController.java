package com.reg.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.reg.cache.DataCache;
import com.reg.dto.ResponseData;
import com.reg.vo.BodyData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangzhiwei
 */
@Api(value = "酒店 产品相关", description = "产品相关")
@RestController
@Slf4j
@CrossOrigin
public class ProductController {

    @ApiOperation(value = "模拟结果", notes = "模拟响应")
    @RequestMapping(value = "/product/{methodName}", method = {RequestMethod.POST})
    public ResponseData queryMock(@PathVariable("methodName") String methodName, @RequestBody com.reg.dto.RequestBody body) {
        Object data = "{\"code\":\"200\"}";
        ResponseData responseData;
        if (!body.getSignResult().isCheck()) {
            data = "{\"code\":\"1000\"}";
        }
        if (body.getSignResult().isCheck() && !CollectionUtils.isEmpty(DataCache.mockData) && DataCache.mockData.containsKey(methodName)) {
            data = DataCache.mockData.get(methodName);
            log.info("return {}", data);
            responseData = JSON.parseObject(data.toString(), ResponseData.class);
        } else {
            responseData = JSON.parseObject(data.toString(), ResponseData.class);
        }
        return responseData;
    }

    @RequestMapping(value = "/product/setMock", method = {RequestMethod.POST})
    public ResponseStandardData setMock(@RequestBody BodyData data) {
        log.info("type:{}", data.getType());
        log.info("data:{}", data.getData());
        DataCache.mockData.put(data.getType(), JSONObject.toJSONString(data.getData()));
        return ResponseStandardData.success();
    }

    @Data
    public static class ResponseStandardData<T> {
        private Integer code;
        private String msg;
        private T data;

        public ResponseStandardData(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public ResponseStandardData(Integer code) {
            this.code = code;
        }

        public ResponseStandardData() {
        }

        public boolean isSuccess() {
            return 200 == this.code;
        }

        public static <T> ResponseStandardData<T> success() {
            return new ResponseStandardData(200, "处理成功! ");
        }

        public static <T> ResponseStandardData<T> success(Object object) {
            ResponseStandardData response = new ResponseStandardData(200, "处理成功! ");
            response.setData(object);
            return response;
        }

        public static <T> ResponseStandardData<T> fail() {
            return new ResponseStandardData(500);
        }

    }
}
