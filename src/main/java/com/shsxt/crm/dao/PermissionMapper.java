package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends BaseDao<Permission>{
    public Integer queryModulesByRoleId(Integer roleId);
    public Integer deleteModulesByRoleId(Integer roleId);

    public Integer queryModulesByAclValue(String aclValue);
    public Integer deleteModulesByAclValue(String aclValue);
}