package com.softdev.system.demo.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 缓存工具类
 * @ClassName: CacheUtil
 * @Author: liangbl
 * @Date: 2020/6/29 13:20
 */
public class CacheUtil {
    //hashMap线程安全类
    private static Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public static void addCache(String key, Object value) {
        cacheMap.put(key, value);
    }

    /**
     * 设置缓存
     *
     * @param key
     * @param value
     */
    public static void setValue(String key, Object value) {
        cacheMap.put(key, value);
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public static Object getValue(String key) {
        return cacheMap.get(key);
    }

    /**
     * 判断key是存在
     *
     * @param key
     * @return
     */
    public static boolean containKey(String key) {
        return cacheMap.containsKey(key);
    }

    /**
     * 移除缓存
     *
     * @param key
     */
    public static void removeCache(String key) {
        cacheMap.remove(key);
    }
}
