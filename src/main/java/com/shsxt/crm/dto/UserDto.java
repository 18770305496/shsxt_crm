package com.shsxt.crm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.crm.po.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xlf on 2018/10/18.
 */
public class UserDto extends User implements Serializable{

    private static final long serialVersionUID = -365799596291347394L;

    private String roleName;
    private String roleIdsStr;// 接收字符串 1,2,3


    List<String> roleNames = new ArrayList<>();// 存角色名称
    private List<Integer> roleIds = new ArrayList<>();// 存id [1,2,3]

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleIdsStr() {
        return roleIdsStr;
    }

    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }


}
