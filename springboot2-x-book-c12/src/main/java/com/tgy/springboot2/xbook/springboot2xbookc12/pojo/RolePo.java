package com.tgy.springboot2.xbook.springboot2xbookc12.pojo;

/**
 * @ClassName RolePo
 */
public class RolePo {
    private Integer id;
    private String roleName;
    private String note;

    @Override
    public String toString() {
        return "RolePo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
