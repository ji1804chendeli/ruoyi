package com.ruoyi.common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工作性质对象 t_medical_base_nature
 * 
 * @author ruoyi
 * @date 2021-11-04
 */
public class TMedicalBaseNature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工作性值ID */
    private Integer natureid;

    /** 性质名称 */
    @Excel(name = "性质名称")
    private String name;

    /** 性质描述 */
    @Excel(name = "性质描述")
    private String description;

    /** 人员/部门 */
    @Excel(name = "人员/部门")
    private String typename;

    public void setNatureid(Integer natureid) 
    {
        this.natureid = natureid;
    }

    public Integer getNatureid() 
    {
        return natureid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setTypename(String typename) 
    {
        this.typename = typename;
    }

    public String getTypename() 
    {
        return typename;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("natureid", getNatureid())
            .append("name", getName())
            .append("description", getDescription())
            .append("typename", getTypename())
            .append("remark", getRemark())
            .toString();
    }
}
