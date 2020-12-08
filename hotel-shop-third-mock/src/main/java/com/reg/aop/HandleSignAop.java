package com.reg.aop;

import com.reg.cache.DataCache;
import com.reg.dto.RequestBody;
import com.reg.util.RSAUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPublicKey;

/**
 * @author wangzhiwei
 */
@Slf4j
@Aspect
@Component
public class HandleSignAop {
    @Before(value = "@annotation(apiOperation)")
    public void valid(JoinPoint joinPoint, ApiOperation apiOperation) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (null != apiOperation) {
            for (Object obj : args) {
                if (obj instanceof RequestBody) {
                    RequestBody body = (RequestBody) obj;
                    String publicKeyStr = DataCache.keyData.get(body.getAppId());
                    RSAPublicKey publicKey = RSAUtils.loadPublicKeyByStr(publicKeyStr, RSAUtils.ALGORITHMS.ENCRYPT_RSA2);
                    String content = "appId=".concat(body.getAppId()).concat("&data=").concat(body.getData().toString()).concat("&signType=").concat(body.getSignType());
                    boolean check = RSAUtils.doCheck(content, body.getSign(), publicKey, RSAUtils.ALGORITHMS.ENCRYPT_RSA2);
                    RequestBody.SignResult signResult = new RequestBody.SignResult();
                    signResult.setCheck(check);
                    ((RequestBody) obj).setSignResult(signResult);
                }
            }
        }
    }
}
