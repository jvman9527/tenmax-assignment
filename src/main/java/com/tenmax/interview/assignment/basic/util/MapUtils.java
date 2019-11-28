package com.tenmax.interview.assignment.basic.util;

import java.util.Map;

public class MapUtils {

    /**
     * 遞迴取得 Map 裡的值
     * @param map
     * @param fieldPath
     */
    public static Object recursivelyGet(Map map, String fieldPath) {
        Object value = map;
        String[] paths = fieldPath.split("\\.");
        for (String path : paths) {
            if (value instanceof Map) {
                value = ((Map) value).get(path);

            } else {
                value = null;
                break;
            }
        }

        return value;
    }

}
