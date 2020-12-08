package com.reg.cache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author wangzhiwei
 */
public class DataCache {

    public static final Map<String, Object> mockData = Maps.newConcurrentMap();
    public static final Map<String, String> keyData = Maps.newConcurrentMap();

}
