package com.shsxt.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.base.BaseQuery;
import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.UserMapper;
import com.shsxt.crm.dao.UserRoleMapper;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.exceptions.ParamsException;
import com.shsxt.crm.model.UserInfo;
import com.shsxt.crm.po.User;
import com.shsxt.crm.po.UserRole;
import com.shsxt.crm.query.UserQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.Md5Util;
import com.shsxt.crm.utils.RedisUtils;
import com.shsxt.crm.utils.UserIDBase64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by xlf on 2018/10/13.
 */
@Service
public class UserService extends BaseService<UserDto> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RedisUtils redisUtils;


    public void deleteUsers(Integer[] ids){
        if(null!=ids && ids.length>0){
            for (Integer userId : ids){
                /***
                 * 1. 删除用户
                 * 2. 删除用户所属角色
                 * */
                AssertUtil.isTrue(userMapper.delete(userId)<1,"用户删除失败");

                //int i = 1/0;//
                Integer rolesNum = userRoleMapper.queryUserRolesByUserId(userId);
                if(rolesNum>0){
                    // 删除
                    AssertUtil.isTrue(userRoleMapper.deleteUserRolesByUserId(userId)<rolesNum, CrmConstant.OPS_FAILED_MSG);
                }

            }
        }
    }

    /**
     * 添加或更新用户
     * @param user
     */
    public void saveOrUpdateUser(UserDto user, Integer[] roleIds){
        /***
         * 1 2 3 4 5
         * */
        checkUserParams(user);
        user.setUpdateDate(new Date());
        Integer id = user.getId();
        if(null == id){
            // 添加
            AssertUtil.isTrue(null!=userMapper.queryUserByName(user.getUserName()),"用户名已存在");
            /***
             * 初始密码: 123456
             * 存时应为加密的字符串
             * */
            user.setUserPwd(Md5Util.encode("123456"));
            user.setIsValid(1);
            user.setCreateDate(new Date());
            AssertUtil.isTrue(userMapper.save(user)<1, CrmConstant.OPS_FAILED_MSG);
        }else{
            // 更新
            /***
             * 1. 用户名不允许修改
             * 2. 更新角色
             *      方案:
             *      123 -> 12  删除
             *      123 -> 1234 添加
             *      123 -> 134  删除添加
             *      先全部删除, 再全部添加
             * */
            AssertUtil.isTrue(!user.getUserName().equals(userMapper.queryById(id).getUserName()),"用户名不允许修改");
            AssertUtil.isTrue(userMapper.update(user)<1, CrmConstant.OPS_FAILED_MSG);

            /***
             * 角色: 先查询改用是否有角色
             * 1) 如果有进行删除再添加
             * 2) 如果没有直接添加
             * */
            Integer rolesNum = userRoleMapper.queryUserRolesByUserId(id);
            if(rolesNum>0){
                // 删除
                AssertUtil.isTrue(userRoleMapper.deleteUserRolesByUserId(id)<rolesNum, CrmConstant.OPS_FAILED_MSG);
            }
        }

        /***
         * 角色添加
         * 1. 判断roleIds 是否为空
         * 2. 获取用户ID
         * */
        if(null!=roleIds && roleIds.length>0){
//                System.out.println("==============");
//                System.out.println("user id : "+user.getId());
//                System.out.println("==============");
            Integer userId = user.getId();
            List<UserRole> userRoles = new ArrayList<>();
            for (Integer roleId : roleIds){
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRole.setCreateDate(new Date());
                userRole.setUpdateDate(new Date());
                userRoles.add(userRole);
            }

            AssertUtil.isTrue(userRoleMapper.saveBatch(userRoles)<userRoles.size(),CrmConstant.OPS_FAILED_MSG);
        }

    }

    private void checkUserParams(User user) {
        /***
         * 1. 非空校验
         * 2. 用户名唯一校验
         * */
        String userName = user.getUserName();
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getTrueName()),"真实姓名为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getEmail()),"邮箱为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getPhone()),"联系方式为空");

    }


    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @param userId
     */
    public void updateUserPwd(String oldPassword,
                              String newPassword,
                              String confirmPassword,
                              Integer userId){
        /***
         * 1. 校验参数, 非空 旧密码是否正确
         * 2. 更新密码
         * */
        checkUpdateUserPwdParams(oldPassword,newPassword,confirmPassword);

        User user = userMapper.queryById(userId);
        AssertUtil.isTrue(null==user, "用户不存在或已注销");
        AssertUtil.isTrue(!Md5Util.encode(oldPassword).equals(user.getUserPwd()),"旧密码不正确");

        /***
         * 存加密之后的字符串
         * */
        String encodeNewPassword = Md5Util.encode(newPassword);
        //userMapper.updateUserPwd(encodeNewPassword, userId);// 不行
        AssertUtil.isTrue(userMapper.updateUserPwd(encodeNewPassword, userId)<1,"用户密码更新失败");
    }

    private void checkUpdateUserPwdParams(String oldPassword, String newPassword, String confirmPassword) {
        AssertUtil.isTrue(StringUtils.isBlank(oldPassword),"旧密码为空");
        AssertUtil.isTrue(StringUtils.isBlank(newPassword),"新密码为空");
        AssertUtil.isTrue(!newPassword.equals(confirmPassword),"两次密码不一致");
    }


    /**
     * 用户登陆
     * @param userName
     * @param userPwd
     */
    public UserInfo login(String userName, String userPwd){
        /**
         * 1. 校验参数 userName 和 userPwd 非空
         * 2. 通过用户名查询用户
         * 3. 匹配密码是否一致
         * */
//        if(null==userName || "".equals(userName)){
//            throw new ParamsException("用户名为空");
//        }
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名为空");
        AssertUtil.isTrue(StringUtils.isBlank(userPwd),"密码为空");

        User user = userMapper.queryUserByName(userName);
        AssertUtil.isTrue(null==user, "用户不存在或已注销");

        /**
         * 前台传明文密码, 后台时加密密码
         * */
        AssertUtil.isTrue(!Md5Util.encode(userPwd).equals(user.getUserPwd()),"用户名或密码不正确");

        return createUserInfo(user);
    }

    private UserInfo createUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
        userInfo.setUserName(user.getUserName());
        userInfo.setRealName(user.getTrueName());
        return userInfo;
    }

    public Map<String,Object> queryForPage(UserQuery baseQuery) throws  DataAccessException{

        // 把查询条件作为key
        Map<String, Object> map2=new HashMap<String, Object>();
        String totalKey="users:userName:"+baseQuery.getUserName()+":email:"+baseQuery.getEmail() +":phone:"+baseQuery.getPhone();
        String queryKey=totalKey+":pageNum:"+baseQuery.getPageNum()+":pageSize:"+baseQuery.getPageSize();
        System.out.println(queryKey);

        // 先从缓存中查询是否有缓存数据,有就直接返回
        List users=redisUtils.getList(queryKey);
        if(!CollectionUtils.isEmpty(users)){

            System.out.println("User Redis Cache");
            map2.put("rows", users);
            map2.put("total",redisUtils.getString(totalKey));
            return map2;
        }





        /********************** - 分页- **************************/
        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        List<UserDto> entities=userMapper.queryByParams(baseQuery);
        PageInfo<UserDto> pageInfo=new PageInfo<UserDto>(entities);
        /********************** - 分页- **************************/

        /********************** - 给easyui的datagrid插件使用- **************************/
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        /***********************给easyui的datagrid插件使用***************************/

        entities = pageInfo.getList();
        /***
         * 需要把 1,2,3  变成 [1,2,3]
         * */
        for(UserDto userDto : entities){
            String roleIdsStr = userDto.getRoleIdsStr();
            if (null!=roleIdsStr){
                String[] roleIdArr = userDto.getRoleIdsStr().split(",");
                List<Integer> roleIdList = new ArrayList<>();
                for (String roleId : roleIdArr) {
                    roleIdList.add(Integer.valueOf(roleId));
                }
                userDto.setRoleIds(roleIdList);
            }
        }

        // 把数据库查询出的数据存入缓存
        if(!CollectionUtils.isEmpty(pageInfo.getList())){
            redisUtils.setString(totalKey, map.get("total"));
            redisUtils.setList(queryKey, pageInfo.getList());
        }

        return map;
    }

    public List<String> queryAllAclValueByUserId(Integer userId){
        return userMapper.queryAllAclValueByUserId(userId);
    }

    public static void main(String[] args) {
        System.out.println("1".split(",").toString());
    }
}
