package com.tgy.springboot2.xbook.springboot2xbookc6.controller.vo;

import java.util.List;

/**
 * @ClassName UserBatchVo
 */
public class UserBatchVo {
    private List<String> names;
    private List<String> notes;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "UserBatchVo{" +
                "names=" + names +
                ", notes=" + notes +
                '}';
    }
}
