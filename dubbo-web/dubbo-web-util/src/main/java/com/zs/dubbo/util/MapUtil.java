package com.zs.dubbo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/7
 **/
public class MapUtil {

    public static Map<String, Object> setResultMap(Object result) {
        Map<String, Object> resultMap = new HashMap<>();
        if (null != result) {
            resultMap.put("code", 200);
            resultMap.put("result", result);
        } else {
            resultMap.put("code", 404);
        }
        return resultMap;
    }
}
