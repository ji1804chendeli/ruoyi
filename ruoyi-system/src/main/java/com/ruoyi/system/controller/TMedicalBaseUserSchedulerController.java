package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.TMedicalBaseUserScheduler;
import com.ruoyi.system.service.ITMedicalBaseUserSchedulerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员休息记录Controller
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
@RestController
@RequestMapping("/system/userScheduler")
public class TMedicalBaseUserSchedulerController extends BaseController
{
    @Autowired
    private ITMedicalBaseUserSchedulerService tMedicalBaseUserSchedulerService;

    /**
     * 查询人员休息记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:userScheduler:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        startPage();
        List<TMedicalBaseUserScheduler> list = tMedicalBaseUserSchedulerService.selectTMedicalBaseUserSchedulerList(tMedicalBaseUserScheduler);
        return getDataTable(list);
    }

    /**
     * 导出人员休息记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:userScheduler:export')")
    @Log(title = "人员休息记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        List<TMedicalBaseUserScheduler> list = tMedicalBaseUserSchedulerService.selectTMedicalBaseUserSchedulerList(tMedicalBaseUserScheduler);
        ExcelUtil<TMedicalBaseUserScheduler> util = new ExcelUtil<TMedicalBaseUserScheduler>(TMedicalBaseUserScheduler.class);
        return util.exportExcel(list, "人员休息记录数据");
    }

    /**
     * 获取人员休息记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:userScheduler:query')")
    @GetMapping(value = "/{userschedulerid}")
    public AjaxResult getInfo(@PathVariable("userschedulerid") String userschedulerid)
    {
        return AjaxResult.success(tMedicalBaseUserSchedulerService.selectTMedicalBaseUserSchedulerByUserschedulerid(userschedulerid));
    }

    /**
     * 新增人员休息记录
     */
    @PreAuthorize("@ss.hasPermi('system:userScheduler:add')")
    @Log(title = "人员休息记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        return toAjax(tMedicalBaseUserSchedulerService.insertTMedicalBaseUserScheduler(tMedicalBaseUserScheduler));
    }

    /**
     * 修改人员休息记录
     */
    @PreAuthorize("@ss.hasPermi('system:userScheduler:edit')")
    @Log(title = "人员休息记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalBaseUserScheduler tMedicalBaseUserScheduler)
    {
        return toAjax(tMedicalBaseUserSchedulerService.updateTMedicalBaseUserScheduler(tMedicalBaseUserScheduler));
    }

    /**
     * 删除人员休息记录
     */
    @PreAuthorize("@ss.hasPermi('system:userScheduler:remove')")
    @Log(title = "人员休息记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userschedulerids}")
    public AjaxResult remove(@PathVariable String[] userschedulerids)
    {
        return toAjax(tMedicalBaseUserSchedulerService.deleteTMedicalBaseUserSchedulerByUserschedulerids(userschedulerids));
    }
}
