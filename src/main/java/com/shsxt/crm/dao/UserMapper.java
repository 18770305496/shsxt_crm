package com.shsxt.crm.dao;

import com.shsxt.crm.base.BaseDao;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.po.User;
import com.shsxt.crm.query.UserQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseDao<UserDto> {
    public User queryUserByName(String userName);
    public Integer updateUserPwd(@Param("userPwd") String userPwd, @Param("id") Integer id);

    public List<String> queryAllAclValueByUserId(Integer userId);
}