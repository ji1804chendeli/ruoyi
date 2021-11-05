package com.ruoyi.common.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.mapper.TMedicalBaseNatureMapper;
import com.ruoyi.common.domain.TMedicalBaseNature;
import com.ruoyi.common.service.ITMedicalBaseNatureService;

/**
 * 工作性质Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-04
 */
@Service
public class TMedicalBaseNatureServiceImpl implements ITMedicalBaseNatureService 
{
    @Autowired
    private TMedicalBaseNatureMapper tMedicalBaseNatureMapper;

    /**
     * 查询工作性质
     * 
     * @param natureid 工作性质主键
     * @return 工作性质
     */
    @Override
    public TMedicalBaseNature selectTMedicalBaseNatureByNatureid(Integer natureid)
    {
        return tMedicalBaseNatureMapper.selectTMedicalBaseNatureByNatureid(natureid);
    }

    /**
     * 查询工作性质列表
     * 
     * @param tMedicalBaseNature 工作性质
     * @return 工作性质
     */
    @Override
    public List<TMedicalBaseNature> selectTMedicalBaseNatureList(TMedicalBaseNature tMedicalBaseNature)
    {
        return tMedicalBaseNatureMapper.selectTMedicalBaseNatureList(tMedicalBaseNature);
    }

    /**
     * 新增工作性质
     * 
     * @param tMedicalBaseNature 工作性质
     * @return 结果
     */
    @Override
    public int insertTMedicalBaseNature(TMedicalBaseNature tMedicalBaseNature)
    {
        return tMedicalBaseNatureMapper.insertTMedicalBaseNature(tMedicalBaseNature);
    }

    /**
     * 修改工作性质
     * 
     * @param tMedicalBaseNature 工作性质
     * @return 结果
     */
    @Override
    public int updateTMedicalBaseNature(TMedicalBaseNature tMedicalBaseNature)
    {
        return tMedicalBaseNatureMapper.updateTMedicalBaseNature(tMedicalBaseNature);
    }

    /**
     * 批量删除工作性质
     * 
     * @param natureids 需要删除的工作性质主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalBaseNatureByNatureids(Integer[] natureids)
    {
        return tMedicalBaseNatureMapper.deleteTMedicalBaseNatureByNatureids(natureids);
    }

    /**
     * 删除工作性质信息
     * 
     * @param natureid 工作性质主键
     * @return 结果
     */
    @Override
    public int deleteTMedicalBaseNatureByNatureid(Integer natureid)
    {
        return tMedicalBaseNatureMapper.deleteTMedicalBaseNatureByNatureid(natureid);
    }

    /**
     * 根据typeName查询所有人员的工作性质
     * @param tMedicalBaseNature
     * @return
     */
    @Override
    public List<TMedicalBaseNature> listPerson(TMedicalBaseNature tMedicalBaseNature) {
        return tMedicalBaseNatureMapper.listPerson(tMedicalBaseNature);
    }
}
