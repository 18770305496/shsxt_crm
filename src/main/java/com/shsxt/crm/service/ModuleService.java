package com.shsxt.crm.service;

import com.shsxt.crm.base.BaseService;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.dao.ModuleMapper;
import com.shsxt.crm.dao.PermissionMapper;
import com.shsxt.crm.dto.ModuleDto;
import com.shsxt.crm.po.Module;
import com.shsxt.crm.po.Permission;
import com.shsxt.crm.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xlf on 2018/10/19.
 */
@Service
public class ModuleService extends BaseService<Module> {
    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    public void deleteModule(Integer[] ids){
        AssertUtil.isTrue(null==ids || ids.length<1, "请选择删除的模块");

        for (Integer moduleId : ids){
            Module module = moduleMapper.queryById(moduleId);
            /**
             * 当前表级联删除
             */
            String optValue = module.getOptValue();
            Integer total = moduleMapper.selectTotalByOptValue(optValue);
            if(total>0){
                AssertUtil.isTrue(moduleMapper.deleteBatchByOptValue(optValue)<total, CrmConstant.OPS_FAILED_MSG);
            }

            /**
             * 权限表级联删除
             */
            Integer total2 = permissionMapper.queryModulesByAclValue(optValue);
            if (total2>0){
                AssertUtil.isTrue(permissionMapper.deleteModulesByAclValue(optValue)<total2, CrmConstant.OPS_FAILED_MSG);
            }
        }



    }

    /**
     * 添加或更新模块
     *
     * @param module
     */
    public void saveOrUpdateModule(Module module) {
        /**
         * 1. 校验参数
         * 2. 补全参数
         * 3. 判断添加或者更新
         * 4. 执行操作
         * */
        checkModuleParams(module);
        module.setUpdateDate(new Date());
        Integer id = module.getId();
        if(null==id){
            module.setIsValid((byte) 1);
            module.setCreateDate(new Date());
            AssertUtil.isTrue(moduleMapper.save(module)<1, CrmConstant.OPS_FAILED_MSG);
        }else{

        }

    }

    private void checkModuleParams(Module module) {
        /***
         * 1. 非空校验
         * */
        String moduleName = module.getModuleName();
        AssertUtil.isTrue(StringUtils.isBlank(moduleName), "模块名称为空");
        String optValue = module.getOptValue();
        AssertUtil.isTrue(StringUtils.isBlank(optValue), "权限码为空");

        /**
         * 2. 唯一校验
         * */
        AssertUtil.isTrue(null != moduleMapper.queryModuleByName(moduleName), "模块名称已存在");
        AssertUtil.isTrue(null != moduleMapper.queryModuleByOptValue(optValue), "权限码已存在");

        Integer grade = module.getGrade();// 菜单层级
        AssertUtil.isTrue(null == grade, "菜单层级为空");
        /***
         * 3. 根基层级确定位数
         *  0  2
         *  1  4
         *  2  6
         * */
        Integer len = (grade + 1) * 2;
        AssertUtil.isTrue(len != optValue.length(), "权限码格不正确,应为" + len + "位");

        if (grade > 0) {
            /***
             * 4. 层级没有问题
             *      当前  上级
             * 1)    0    null
             * 2)    1    0
             * 3)    2    1
             *
             * 已知上级菜单的id, 需要获取他的层级
             * */
            Module parentModule = moduleMapper.queryById(module.getParentId());// 父模块
            Integer parentGrade = parentModule.getGrade();// 父模块层级
            AssertUtil.isTrue(grade-parentGrade!=1, "菜单层级不正确");

            /***
             * 5. 权限码格式
             * 1) 10   ->   10xx √     20xx  20xxxx  ×
             * 2) 1010   ->   1010xx √     1020xx  20xxxx  ×
             *
             * 如果判断字符串是以指定字符串开头???
             * */
            String parentOptValue = parentModule.getOptValue();
            AssertUtil.isTrue(optValue.indexOf(parentOptValue)!=0,"权限格式不正确,格式应为:"+parentOptValue+"xx");
        } else {
            module.setParentId(null);
        }
    }


    public List<ModuleDto> queryAllModuleByRoleId(Integer roleId) {
        return moduleMapper.queryAllModuleByRoleId(roleId);
    }

    public List<Map> queryModulesByGrade(Integer grade) {
        return moduleMapper.queryModulesByGrade(grade);
    }

    public static void main(String[] args) {
        String code01 = "1010";
        String code02 = "1010xx";// √   true
        String code03 = "1020xx";// x   false
        String code04 = "201010xx";// x   false
        // indexOf
        System.out.println(code02.indexOf(code01)==0);
        System.out.println(code03.indexOf(code01)==0);
        System.out.println(code04.indexOf(code01)==0);

    }
}
