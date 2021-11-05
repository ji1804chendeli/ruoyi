package com.ruoyi.common.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.domain.TMedicalBaseNature;
import com.ruoyi.common.service.ITMedicalBaseNatureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工作性质Controller
 * 
 * @author ruoyi
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/common/nature")
public class TMedicalBaseNatureController extends BaseController
{
    @Autowired
    private ITMedicalBaseNatureService tMedicalBaseNatureService;

    /**
     * 查询工作性质列表
     */
    @PreAuthorize("@ss.hasPermi('common:nature:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalBaseNature tMedicalBaseNature)
    {
        startPage();
        List<TMedicalBaseNature> list = tMedicalBaseNatureService.selectTMedicalBaseNatureList(tMedicalBaseNature);
        return getDataTable(list);
    }

    /**
     * 导出工作性质列表
     */
    @PreAuthorize("@ss.hasPermi('common:nature:export')")
    @Log(title = "工作性质", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalBaseNature tMedicalBaseNature)
    {
        List<TMedicalBaseNature> list = tMedicalBaseNatureService.selectTMedicalBaseNatureList(tMedicalBaseNature);
        ExcelUtil<TMedicalBaseNature> util = new ExcelUtil<TMedicalBaseNature>(TMedicalBaseNature.class);
        return util.exportExcel(list, "工作性质数据");
    }

    /**
     * 获取工作性质详细信息
     */
    @PreAuthorize("@ss.hasPermi('common:nature:query')")
    @GetMapping(value = "/{natureid}")
    public AjaxResult getInfo(@PathVariable("natureid") Integer natureid)
    {
        return AjaxResult.success(tMedicalBaseNatureService.selectTMedicalBaseNatureByNatureid(natureid));
    }

    /**
     * 新增工作性质
     */
    @PreAuthorize("@ss.hasPermi('common:nature:add')")
    @Log(title = "工作性质", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalBaseNature tMedicalBaseNature)
    {
        return toAjax(tMedicalBaseNatureService.insertTMedicalBaseNature(tMedicalBaseNature));
    }

    /**
     * 修改工作性质
     */
    @PreAuthorize("@ss.hasPermi('common:nature:edit')")
    @Log(title = "工作性质", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalBaseNature tMedicalBaseNature)
    {
        return toAjax(tMedicalBaseNatureService.updateTMedicalBaseNature(tMedicalBaseNature));
    }

    /**
     * 删除工作性质
     */
    @PreAuthorize("@ss.hasPermi('common:nature:remove')")
    @Log(title = "工作性质", businessType = BusinessType.DELETE)
	@DeleteMapping("/{natureids}")
    public AjaxResult remove(@PathVariable Integer[] natureids)
    {
        return toAjax(tMedicalBaseNatureService.deleteTMedicalBaseNatureByNatureids(natureids));
    }
}
