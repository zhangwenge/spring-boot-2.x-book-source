package com.tgy.springboot2.xbook.springboot2xbookc6.controller.vo;

import com.tgy.springboot2.xbook.springboot2xbookc6.common.vo.BaseRspBo;
import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;

import java.util.List;

/**
 * @ClassName UserInsertBatchRspBo
 */
public class UserInsertBatchRspBo extends BaseRspBo {

    private boolean success;
    private List<User> users;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserInsertBatchRspBo{" +
                "success=" + success +
                ", users=" + users +
                "} " + super.toString();
    }
}
