package com.ruoyi.guarantee.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.guarantee.domain.GuaApply;
import com.ruoyi.guarantee.service.IGuaApplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物资调用申请记录Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/guarantee/apply")
public class GuaApplyController extends BaseController
{
    @Autowired
    private IGuaApplyService guaApplyService;

    /**
     * 查询物资调用申请记录列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(GuaApply guaApply)
    {
        startPage();
        List<GuaApply> list = guaApplyService.selectGuaApplyList(guaApply);
        return getDataTable(list);
    }

    /**
     * 导出物资调用申请记录列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:apply:export')")
    @Log(title = "物资调用申请记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GuaApply guaApply)
    {
        List<GuaApply> list = guaApplyService.selectGuaApplyList(guaApply);
        ExcelUtil<GuaApply> util = new ExcelUtil<GuaApply>(GuaApply.class);
        util.exportExcel(response, list, "物资调用申请记录数据");
    }

    /**
     * 获取物资调用申请记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:apply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(guaApplyService.selectGuaApplyById(id));
    }

    /**
     * 新增物资调用申请记录
     */
    @PreAuthorize("@ss.hasPermi('guarantee:apply:add')")
    @Log(title = "物资调用申请记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GuaApply guaApply)
    {
        return toAjax(guaApplyService.insertGuaApply(guaApply));
    }

    /**
     * 修改物资调用申请记录
     */
    @PreAuthorize("@ss.hasPermi('guarantee:apply:edit')")
    @Log(title = "物资调用申请记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GuaApply guaApply)
    {
        return toAjax(guaApplyService.updateGuaApply(guaApply));
    }

    /**
     * 删除物资调用申请记录
     */
    @PreAuthorize("@ss.hasPermi('guarantee:apply:remove')")
    @Log(title = "物资调用申请记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(guaApplyService.deleteGuaApplyByIds(ids));
    }
}
