package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员休息记录对象 t_medical_base_user_scheduler
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
public class TMedicalBaseUserScheduler extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人员休息记录表ID */
    private String userschedulerid;

    /** 人员ID */
    @Excel(name = "人员ID")
    private Long userId;

    /** 人员休息日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "人员休息日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date restdate;

    /** 休息时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "休息时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datedetail;

    /** 部门排班记录ID */
    @Excel(name = "部门排班记录ID")
    private String groupschedulerid;

    /** 人员休息记录备注 */
    @Excel(name = "人员休息记录备注")
    private String remarks;

    public void setUserschedulerid(String userschedulerid) 
    {
        this.userschedulerid = userschedulerid;
    }

    public String getUserschedulerid() 
    {
        return userschedulerid;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRestdate(Date restdate) 
    {
        this.restdate = restdate;
    }

    public Date getRestdate() 
    {
        return restdate;
    }
    public void setDatedetail(Date datedetail) 
    {
        this.datedetail = datedetail;
    }

    public Date getDatedetail() 
    {
        return datedetail;
    }
    public void setGroupschedulerid(String groupschedulerid) 
    {
        this.groupschedulerid = groupschedulerid;
    }

    public String getGroupschedulerid() 
    {
        return groupschedulerid;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userschedulerid", getUserschedulerid())
            .append("userId", getUserId())
            .append("restdate", getRestdate())
            .append("datedetail", getDatedetail())
            .append("groupschedulerid", getGroupschedulerid())
            .append("remarks", getRemarks())
            .toString();
    }
}
