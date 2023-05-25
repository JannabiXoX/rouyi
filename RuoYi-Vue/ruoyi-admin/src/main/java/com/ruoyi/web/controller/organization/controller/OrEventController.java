package com.ruoyi.web.controller.organization.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.organization.domain.OrEvent;
import com.ruoyi.web.controller.organization.service.IOrEventService;
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
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应急事件Controller
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
@RestController
@RequestMapping("/organization/event")
public class OrEventController extends BaseController
{
    @Autowired
    private IOrEventService orEventService;

    /**
     * 查询应急事件列表
     */
    @PreAuthorize("@ss.hasPermi('organization:event:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrEvent orEvent)
    {
        startPage();
        List<OrEvent> list = orEventService.selectOrEventList(orEvent);
        return getDataTable(list);
    }

    /**
     * 导出应急事件列表
     */
    @PreAuthorize("@ss.hasPermi('organization:event:export')")
    @Log(title = "应急事件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrEvent orEvent)
    {
        List<OrEvent> list = orEventService.selectOrEventList(orEvent);
        ExcelUtil<OrEvent> util = new ExcelUtil<OrEvent>(OrEvent.class);
        util.exportExcel(response, list, "应急事件数据");
    }

    /**
     * 获取应急事件详细信息
     */
    @PreAuthorize("@ss.hasPermi('organization:event:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orEventService.selectOrEventById(id));
    }

    /**
     * 新增应急事件
     */
    @PreAuthorize("@ss.hasPermi('organization:event:add')")
    @Log(title = "应急事件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrEvent orEvent)
    {
        return toAjax(orEventService.insertOrEvent(orEvent));
    }

    /**
     * 修改应急事件
     */
    @PreAuthorize("@ss.hasPermi('organization:event:edit')")
    @Log(title = "应急事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrEvent orEvent)
    {
        return toAjax(orEventService.updateOrEvent(orEvent));
    }

    /**
     * 删除应急事件
     */
    @PreAuthorize("@ss.hasPermi('organization:event:remove')")
    @Log(title = "应急事件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orEventService.deleteOrEventByIds(ids));
    }
}
