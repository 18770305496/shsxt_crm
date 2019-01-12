package com.shsxt.crm.controller;

import com.shsxt.crm.annotations.RequestPermission;
import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.constants.CrmConstant;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xlf on 2018/10/15.
 */
@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController {

    @Autowired
    private SaleChanceService saleChanceService;

    @RequestMapping("index/{state}")
    public String index(@PathVariable Integer state) {
        if(state == 1){
            return "sale_chance";
        }else if(state == 2){
            return "cus_dev_plan";
        }
        return "error";
    }

    @RequestPermission(aclValue = "101001")
    @RequestMapping("querySaleChancesByParams")
    @ResponseBody
    public Map<String, Object> querySaleChancesByParams(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            SaleChanceQuery query) {
        query.setPageNum(page);
        query.setPageSize(rows);
        return saleChanceService.queryForPage(query);
    }

    @RequestMapping("saveOrUpdateSaleChance")
    @ResponseBody
    public ResultInfo saveOrUpdateSaleChance(SaleChance saleChance, HttpServletRequest request) {
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        saleChanceService.saveOrUpdateSaleChance(saleChance, userId);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }

    @RequestMapping("queryAllCustomerManager")
    @ResponseBody
    public List<Map> queryAllCustomerManager(){
        return saleChanceService.queryAllCustomerManager();
    }

    @RequestMapping("deleteSaleChanceBatch")
    @ResponseBody
    public ResultInfo deleteSaleChanceBatch(Integer[] ids){
        saleChanceService.deleteBatch(ids);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }

    @RequestMapping("updateSaleChanceDevResult")
    @ResponseBody
    public ResultInfo updateSaleChanceDevResult(SaleChance saleChance){
        saleChanceService.updateSaleChanceDevResult(saleChance);
        return success(CrmConstant.OPS_SUCCESS_MSG);
    }
}
