package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.po.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper extends BaseDao<Role>{
  public List<Map> queryAllRoles();
  public Role queryRoleByName(String roleName);
}