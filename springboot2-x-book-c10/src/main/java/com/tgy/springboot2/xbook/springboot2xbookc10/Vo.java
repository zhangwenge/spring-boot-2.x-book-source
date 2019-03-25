package com.tgy.springboot2.xbook.springboot2xbookc10;

import java.util.List;

/**
 * @ClassName Vo
 */
public class Vo {
    private List<String> strs;

    @Override
    public String toString() {
        return "Vo{" +
                "strs=" + strs +
                '}';
    }

    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }
}
