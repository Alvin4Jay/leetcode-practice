package com.jay.leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * desc.
 *
 * @author zhongshuo.xwj
 */
public class Lru<K, V> extends LinkedHashMap<K, V> {

    private final int cacheSzie;

    public Lru(int cacheSzie) {
        super(16, 0.75f, true);
        this.cacheSzie = cacheSzie;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSzie;
    }

}
