package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalBaseGroupSchedulerMapper;
import com.ruoyi.system.domain.TMedicalBaseGroupScheduler;
import com.ruoyi.system.service.ITMedicalBaseGroupSchedulerService;

/**
 * 部门排班记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
@Service
public class TMedicalBaseGroupSchedulerServiceImpl implements ITMedicalBaseGroupSchedulerService 
{
    @Autowired
    private TMedicalBaseGroupSchedulerMapper tMedicalBaseGroupSchedulerMapper;

    /**
     * 查询部门排班记录
     * 
     * @param groupschedulerid 部门排班记录主键
     * @return 部门排班记录
     */
    @Override
    public TMedicalBaseGroupScheduler selectTMedicalBaseGroupSchedulerByGroupschedulerid(String groupschedulerid)
    {
        return tMedicalBaseGroupSchedulerMapper.selectTMedicalBaseGroupSchedulerByGroupschedulerid(groupschedulerid);
    }

    /**
     * 查询部门排班记录列表
     * 
     * @param tMedicalBaseGroupScheduler 部门排班记录
     * @return 部门排班记录
     */
    @Override
    public List<TMedicalBaseGroupScheduler> selectTMedicalBaseGroupSchedulerList(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        return tMedicalBaseGroupSchedulerMapper.selectTMedicalBaseGroupSchedulerList(tMedicalBaseGroupScheduler);
    }

    /**
     * 新增部门排班记录
     * 
     * @param tMedicalBaseGroupScheduler 部门排班记录
     * @return 结果
     */
    @Override
    public int insertTMedicalBaseGroupScheduler(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        return tMedicalBaseGroupSchedulerMapper.insertTMedicalBaseGroupScheduler(tMedicalBaseGroupScheduler);
    }

    /**
     * 修改部门排班记录
     * 
     * @param tMedicalBaseGroupScheduler 部门排班记录
     * @return 结果
     */
    @Override
    public int updateTMedicalBaseGroupScheduler(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        return tMedicalBaseGroupSchedulerMapper.updateTMedicalBaseGroupScheduler(tMedicalBaseGroupScheduler);
    }

    /**
     * 批量删除部门排班记录
     * 
     * @param groupschedulerids 需要删除的部门排班记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalBaseGroupSchedulerByGroupschedulerids(String[] groupschedulerids)
    {
        return tMedicalBaseGroupSchedulerMapper.deleteTMedicalBaseGroupSchedulerByGroupschedulerids(groupschedulerids);
    }

    /**
     * 删除部门排班记录信息
     * 
     * @param groupschedulerid 部门排班记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalBaseGroupSchedulerByGroupschedulerid(String groupschedulerid)
    {
        return tMedicalBaseGroupSchedulerMapper.deleteTMedicalBaseGroupSchedulerByGroupschedulerid(groupschedulerid);
    }
}
