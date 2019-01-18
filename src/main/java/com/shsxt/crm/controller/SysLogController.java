package com.shsxt.crm.controller;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.SysLog;
import com.shsxt.crm.query.SysLogQuery;
import com.shsxt.crm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("sysLog")
public class SysLogController extends BaseController{

    @Autowired
    private SysLogService sysLogService;

    /**
     * 页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "sys_log";
    }
    /**
     * 信息列表
     * @param page
     * @param rows
     * @param query
     * @return
     */
    @RequestMapping("queryCustomersByParams")
    @ResponseBody
    public Map<String, Object> queryCustomersByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            SysLogQuery query) {
        query.setPageNum(page);
        query.setPageSize(rows);
        return sysLogService.queryForPage(query);
    }

    /**
     * 保存客户用户信息 或者更新用户信息
     * @param sysLog
     * @return
     */
    @RequestMapping("saveOrUpdateSysLog")
    @ResponseBody
    public ResultInfo saveOrUpdateSysLog(SysLog sysLog){

        //保存客户信息
        sysLogService.saveOrUpdateSysLog(sysLog);

        return success(CrmConstant.OPS_SUCCESS_MSG);
    }
    /**
     * 删除公司信息
     * @param ids
     * @return
     */
    @RequestMapping("deleteCustomerBatch")
    @ResponseBody
    public ResultInfo deleteCustomerBatch(Integer[] ids){
        sysLogService.deleteBatch(ids);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }
}
