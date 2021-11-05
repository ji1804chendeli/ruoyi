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
import com.ruoyi.system.domain.TMedicalBaseGroupScheduler;
import com.ruoyi.system.service.ITMedicalBaseGroupSchedulerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门排班记录Controller
 * 
 * @author ruoyi
 * @date 2021-11-05
 */
@RestController
@RequestMapping("/system/groupScheduler")
public class TMedicalBaseGroupSchedulerController extends BaseController
{
    @Autowired
    private ITMedicalBaseGroupSchedulerService tMedicalBaseGroupSchedulerService;

    /**
     * 查询部门排班记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:groupScheduler:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        startPage();
        List<TMedicalBaseGroupScheduler> list = tMedicalBaseGroupSchedulerService.selectTMedicalBaseGroupSchedulerList(tMedicalBaseGroupScheduler);
        return getDataTable(list);
    }

    /**
     * 导出部门排班记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:groupScheduler:export')")
    @Log(title = "部门排班记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        List<TMedicalBaseGroupScheduler> list = tMedicalBaseGroupSchedulerService.selectTMedicalBaseGroupSchedulerList(tMedicalBaseGroupScheduler);
        ExcelUtil<TMedicalBaseGroupScheduler> util = new ExcelUtil<TMedicalBaseGroupScheduler>(TMedicalBaseGroupScheduler.class);
        return util.exportExcel(list, "部门排班记录数据");
    }

    /**
     * 获取部门排班记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:groupScheduler:query')")
    @GetMapping(value = "/{groupschedulerid}")
    public AjaxResult getInfo(@PathVariable("groupschedulerid") String groupschedulerid)
    {
        return AjaxResult.success(tMedicalBaseGroupSchedulerService.selectTMedicalBaseGroupSchedulerByGroupschedulerid(groupschedulerid));
    }

    /**
     * 新增部门排班记录
     */
    @PreAuthorize("@ss.hasPermi('system:groupScheduler:add')")
    @Log(title = "部门排班记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        return toAjax(tMedicalBaseGroupSchedulerService.insertTMedicalBaseGroupScheduler(tMedicalBaseGroupScheduler));
    }

    /**
     * 修改部门排班记录
     */
    @PreAuthorize("@ss.hasPermi('system:groupScheduler:edit')")
    @Log(title = "部门排班记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalBaseGroupScheduler tMedicalBaseGroupScheduler)
    {
        return toAjax(tMedicalBaseGroupSchedulerService.updateTMedicalBaseGroupScheduler(tMedicalBaseGroupScheduler));
    }

    /**
     * 删除部门排班记录
     */
    @PreAuthorize("@ss.hasPermi('system:groupScheduler:remove')")
    @Log(title = "部门排班记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupschedulerids}")
    public AjaxResult remove(@PathVariable String[] groupschedulerids)
    {
        return toAjax(tMedicalBaseGroupSchedulerService.deleteTMedicalBaseGroupSchedulerByGroupschedulerids(groupschedulerids));
    }
}
