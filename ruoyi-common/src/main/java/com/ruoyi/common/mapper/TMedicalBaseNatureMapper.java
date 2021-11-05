package com.ruoyi.common.mapper;

import java.util.List;
import com.ruoyi.common.domain.TMedicalBaseNature;
import org.springframework.stereotype.Repository;

/**
 * 工作性质Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-04
 */
@Repository
public interface TMedicalBaseNatureMapper 
{
    /**
     * 查询工作性质
     * 
     * @param natureid 工作性质主键
     * @return 工作性质
     */
    public TMedicalBaseNature selectTMedicalBaseNatureByNatureid(Integer natureid);

    /**
     * 查询工作性质列表
     * 
     * @param tMedicalBaseNature 工作性质
     * @return 工作性质集合
     */
    public List<TMedicalBaseNature> selectTMedicalBaseNatureList(TMedicalBaseNature tMedicalBaseNature);

    /**
     * 新增工作性质
     * 
     * @param tMedicalBaseNature 工作性质
     * @return 结果
     */
    public int insertTMedicalBaseNature(TMedicalBaseNature tMedicalBaseNature);

    /**
     * 修改工作性质
     * 
     * @param tMedicalBaseNature 工作性质
     * @return 结果
     */
    public int updateTMedicalBaseNature(TMedicalBaseNature tMedicalBaseNature);

    /**
     * 删除工作性质
     * 
     * @param natureid 工作性质主键
     * @return 结果
     */
    public int deleteTMedicalBaseNatureByNatureid(Integer natureid);

    /**
     * 批量删除工作性质
     * 
     * @param natureids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTMedicalBaseNatureByNatureids(Integer[] natureids);

    /**
     * 根据typeName查询所有人员的工作性质
     * @param tMedicalBaseNature
     * @return
     */
    public List<TMedicalBaseNature> listPerson(TMedicalBaseNature tMedicalBaseNature);
}
