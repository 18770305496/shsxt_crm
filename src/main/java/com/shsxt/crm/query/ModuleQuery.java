package com.shsxt.crm.query;

import com.shsxt.crm.base.BaseQuery;

/**
 * Created by xlf on 2018/10/20.
 */
public class ModuleQuery extends BaseQuery {

    private String moduleName;

    private Integer parentId;

    private Integer grade;

    private String optValue;


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getOptValue() {
        return optValue;
    }

    public void setOptValue(String optValue) {
        this.optValue = optValue;
    }
}
