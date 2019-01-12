package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper extends BaseDao<UserRole> {
    public Integer queryUserRolesByUserId(Integer userId);
    public Integer deleteUserRolesByUserId(Integer userIRole);
    public Integer queryUserRolesByRoleId(Integer roleId);
    public Integer deleteUserRolesByRoleId(Integer roleId);

}