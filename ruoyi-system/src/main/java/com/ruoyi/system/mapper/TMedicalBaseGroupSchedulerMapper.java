package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TMedicalBaseGroupScheduler;

/**
 * 部门排班记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
public interface TMedicalBaseGroupSchedulerMapper 
{
    /**
     * 查询部门排班记录
     * 
     * @param groupschedulerid 部门排班记录主键
     * @return 部门排班记录
     */
    public TMedicalBaseGroupScheduler selectTMedicalBaseGroupSchedulerByGroupschedulerid(String groupschedulerid);

    /**
     * 查询部门排班记录列表
     * 
     * @param tMedicalBaseGroupScheduler 部门排班记录
     * @return 部门排班记录集合
     */
    public List<TMedicalBaseGroupScheduler> selectTMedicalBaseGroupSchedulerList(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler);

    /**
     * 新增部门排班记录
     * 
     * @param tMedicalBaseGroupScheduler 部门排班记录
     * @return 结果
     */
    public int insertTMedicalBaseGroupScheduler(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler);

    /**
     * 修改部门排班记录
     * 
     * @param tMedicalBaseGroupScheduler 部门排班记录
     * @return 结果
     */
    public int updateTMedicalBaseGroupScheduler(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler);

    /**
     * 删除部门排班记录
     * 
     * @param groupschedulerid 部门排班记录主键
     * @return 结果
     */
    public int deleteTMedicalBaseGroupSchedulerByGroupschedulerid(String groupschedulerid);

    /**
     * 批量删除部门排班记录
     * 
     * @param groupschedulerids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalBaseGroupSchedulerByGroupschedulerids(String[] groupschedulerids);
}
