package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门排班记录对象 t_medical_base_group_scheduler
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
public class TMedicalBaseGroupScheduler extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门排班记录ID */
    private String groupschedulerid;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 星期一上午 */
    @Excel(name = "星期一上午")
    private String mondaymorning;

    /** 星期一下午 */
    @Excel(name = "星期一下午")
    private String mondayafternoon;

    /** 星期二上午 */
    @Excel(name = "星期二上午")
    private String tuesdaymorning;

    /** 星期二下午 */
    @Excel(name = "星期二下午")
    private String tuesdayafternoon;

    /** 星期三上午 */
    @Excel(name = "星期三上午")
    private String wednesdaymorning;

    /** 星期三下午 */
    @Excel(name = "星期三下午")
    private String wednesdayafternoon;

    /** 星期四上午 */
    @Excel(name = "星期四上午")
    private String thursdaymorning;

    /** 星期四下午 */
    @Excel(name = "星期四下午")
    private String thursdayafternoon;

    /** 星期五上午 */
    @Excel(name = "星期五上午")
    private String fridaymorning;

    /** 星期五下午 */
    @Excel(name = "星期五下午")
    private String fridayafternoon;

    /** 星期六上午 */
    @Excel(name = "星期六上午")
    private String saturdaymorning;

    /** 星期六下午 */
    @Excel(name = "星期六下午")
    private String saturdayafternoon;

    /** 星期天上午 */
    @Excel(name = "星期天上午")
    private String sundaymorning;

    /** 星期天下午 */
    @Excel(name = "星期天下午")
    private String sundayafternoon;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtimes;

    /** 排班记录备注 */
    @Excel(name = "排班记录备注")
    private String remarks;

    /** 部门排班记录状态 */
    @Excel(name = "部门排班记录状态")
    private Integer status;

    public void setGroupschedulerid(String groupschedulerid) 
    {
        this.groupschedulerid = groupschedulerid;
    }

    public String getGroupschedulerid() 
    {
        return groupschedulerid;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setMondaymorning(String mondaymorning) 
    {
        this.mondaymorning = mondaymorning;
    }

    public String getMondaymorning() 
    {
        return mondaymorning;
    }
    public void setMondayafternoon(String mondayafternoon) 
    {
        this.mondayafternoon = mondayafternoon;
    }

    public String getMondayafternoon() 
    {
        return mondayafternoon;
    }
    public void setTuesdaymorning(String tuesdaymorning) 
    {
        this.tuesdaymorning = tuesdaymorning;
    }

    public String getTuesdaymorning() 
    {
        return tuesdaymorning;
    }
    public void setTuesdayafternoon(String tuesdayafternoon) 
    {
        this.tuesdayafternoon = tuesdayafternoon;
    }

    public String getTuesdayafternoon() 
    {
        return tuesdayafternoon;
    }
    public void setWednesdaymorning(String wednesdaymorning) 
    {
        this.wednesdaymorning = wednesdaymorning;
    }

    public String getWednesdaymorning() 
    {
        return wednesdaymorning;
    }
    public void setWednesdayafternoon(String wednesdayafternoon) 
    {
        this.wednesdayafternoon = wednesdayafternoon;
    }

    public String getWednesdayafternoon() 
    {
        return wednesdayafternoon;
    }
    public void setThursdaymorning(String thursdaymorning) 
    {
        this.thursdaymorning = thursdaymorning;
    }

    public String getThursdaymorning() 
    {
        return thursdaymorning;
    }
    public void setThursdayafternoon(String thursdayafternoon) 
    {
        this.thursdayafternoon = thursdayafternoon;
    }

    public String getThursdayafternoon() 
    {
        return thursdayafternoon;
    }
    public void setFridaymorning(String fridaymorning) 
    {
        this.fridaymorning = fridaymorning;
    }

    public String getFridaymorning() 
    {
        return fridaymorning;
    }
    public void setFridayafternoon(String fridayafternoon) 
    {
        this.fridayafternoon = fridayafternoon;
    }

    public String getFridayafternoon() 
    {
        return fridayafternoon;
    }
    public void setSaturdaymorning(String saturdaymorning) 
    {
        this.saturdaymorning = saturdaymorning;
    }

    public String getSaturdaymorning() 
    {
        return saturdaymorning;
    }
    public void setSaturdayafternoon(String saturdayafternoon) 
    {
        this.saturdayafternoon = saturdayafternoon;
    }

    public String getSaturdayafternoon() 
    {
        return saturdayafternoon;
    }
    public void setSundaymorning(String sundaymorning) 
    {
        this.sundaymorning = sundaymorning;
    }

    public String getSundaymorning() 
    {
        return sundaymorning;
    }
    public void setSundayafternoon(String sundayafternoon) 
    {
        this.sundayafternoon = sundayafternoon;
    }

    public String getSundayafternoon() 
    {
        return sundayafternoon;
    }
    public void setCreatetimes(Date createtimes) 
    {
        this.createtimes = createtimes;
    }

    public Date getCreatetimes() 
    {
        return createtimes;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("groupschedulerid", getGroupschedulerid())
            .append("deptId", getDeptId())
            .append("mondaymorning", getMondaymorning())
            .append("mondayafternoon", getMondayafternoon())
            .append("tuesdaymorning", getTuesdaymorning())
            .append("tuesdayafternoon", getTuesdayafternoon())
            .append("wednesdaymorning", getWednesdaymorning())
            .append("wednesdayafternoon", getWednesdayafternoon())
            .append("thursdaymorning", getThursdaymorning())
            .append("thursdayafternoon", getThursdayafternoon())
            .append("fridaymorning", getFridaymorning())
            .append("fridayafternoon", getFridayafternoon())
            .append("saturdaymorning", getSaturdaymorning())
            .append("saturdayafternoon", getSaturdayafternoon())
            .append("sundaymorning", getSundaymorning())
            .append("sundayafternoon", getSundayafternoon())
            .append("createtimes", getCreatetimes())
            .append("remarks", getRemarks())
            .append("status", getStatus())
            .toString();
    }
}
