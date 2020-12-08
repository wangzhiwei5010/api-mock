package com.reg.web;

import com.reg.cache.DataCache;
import com.reg.vo.KeyData;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangzhiwei
 */
@Api(value = "酒店 密钥相关", description = "密钥相关")
@RestController
@Slf4j
@CrossOrigin
public class PublicKeyController {

    @RequestMapping(value = "/key/setPublic", method = {RequestMethod.POST})
    public StaticController.ResponseStandardData setPublicKey(@RequestBody KeyData data) {
        log.info("appId:{}", data.getAppId());
        log.info("key:{}", data.getData());
        DataCache.keyData.put(data.getAppId(), data.getData());
        return StaticController.ResponseStandardData.success();
    }
}
