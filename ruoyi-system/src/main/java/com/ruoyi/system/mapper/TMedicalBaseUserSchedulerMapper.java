package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TMedicalBaseUserScheduler;

/**
 * 人员休息记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
public interface TMedicalBaseUserSchedulerMapper 
{
    /**
     * 查询人员休息记录
     * 
     * @param userschedulerid 人员休息记录主键
     * @return 人员休息记录
     */
    public TMedicalBaseUserScheduler selectTMedicalBaseUserSchedulerByUserschedulerid(String userschedulerid);

    /**
     * 查询人员休息记录列表
     * 
     * @param tMedicalBaseUserScheduler 人员休息记录
     * @return 人员休息记录集合
     */
    public List<TMedicalBaseUserScheduler> selectTMedicalBaseUserSchedulerList(TMedicalBaseUserScheduler tMedicalBaseUserScheduler);

    /**
     * 新增人员休息记录
     * 
     * @param tMedicalBaseUserScheduler 人员休息记录
     * @return 结果
     */
    public int insertTMedicalBaseUserScheduler(TMedicalBaseUserScheduler tMedicalBaseUserScheduler);

    /**
     * 修改人员休息记录
     * 
     * @param tMedicalBaseUserScheduler 人员休息记录
     * @return 结果
     */
    public int updateTMedicalBaseUserScheduler(TMedicalBaseUserScheduler tMedicalBaseUserScheduler);

    /**
     * 删除人员休息记录
     * 
     * @param userschedulerid 人员休息记录主键
     * @return 结果
     */
    public int deleteTMedicalBaseUserSchedulerByUserschedulerid(String userschedulerid);

    /**
     * 批量删除人员休息记录
     * 
     * @param userschedulerids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalBaseUserSchedulerByUserschedulerids(String[] userschedulerids);
}
