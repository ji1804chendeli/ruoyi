package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TMedicalBaseUserSchedulerMapper;
import com.ruoyi.system.domain.TMedicalBaseUserScheduler;
import com.ruoyi.system.service.ITMedicalBaseUserSchedulerService;

/**
 * 人员休息记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
@Service
public class TMedicalBaseUserSchedulerServiceImpl implements ITMedicalBaseUserSchedulerService 
{
    @Autowired
    private TMedicalBaseUserSchedulerMapper tMedicalBaseUserSchedulerMapper;

    /**
     * 查询人员休息记录
     * 
     * @param userschedulerid 人员休息记录主键
     * @return 人员休息记录
     */
    @Override
    public TMedicalBaseUserScheduler selectTMedicalBaseUserSchedulerByUserschedulerid(String userschedulerid)
    {
        return tMedicalBaseUserSchedulerMapper.selectTMedicalBaseUserSchedulerByUserschedulerid(userschedulerid);
    }

    /**
     * 查询人员休息记录列表
     * 
     * @param tMedicalBaseUserScheduler 人员休息记录
     * @return 人员休息记录
     */
    @Override
    public List<TMedicalBaseUserScheduler> selectTMedicalBaseUserSchedulerList(TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        return tMedicalBaseUserSchedulerMapper.selectTMedicalBaseUserSchedulerList(tMedicalBaseUserScheduler);
    }

    /**
     * 新增人员休息记录
     * 
     * @param tMedicalBaseUserScheduler 人员休息记录
     * @return 结果
     */
    @Override
    public int insertTMedicalBaseUserScheduler(TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        return tMedicalBaseUserSchedulerMapper.insertTMedicalBaseUserScheduler(tMedicalBaseUserScheduler);
    }

    /**
     * 修改人员休息记录
     * 
     * @param tMedicalBaseUserScheduler 人员休息记录
     * @return 结果
     */
    @Override
    public int updateTMedicalBaseUserScheduler(TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        return tMedicalBaseUserSchedulerMapper.updateTMedicalBaseUserScheduler(tMedicalBaseUserScheduler);
    }

    /**
     * 批量删除人员休息记录
     * 
     * @param userschedulerids 需要删除的人员休息记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalBaseUserSchedulerByUserschedulerids(String[] userschedulerids)
    {
        return tMedicalBaseUserSchedulerMapper.deleteTMedicalBaseUserSchedulerByUserschedulerids(userschedulerids);
    }

    /**
     * 删除人员休息记录信息
     * 
     * @param userschedulerid 人员休息记录主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalBaseUserSchedulerByUserschedulerid(String userschedulerid)
    {
        return tMedicalBaseUserSchedulerMapper.deleteTMedicalBaseUserSchedulerByUserschedulerid(userschedulerid);
    }
}
