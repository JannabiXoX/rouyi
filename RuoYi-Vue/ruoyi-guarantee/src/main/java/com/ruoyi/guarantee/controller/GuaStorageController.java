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
import com.ruoyi.guarantee.domain.GuaStorage;
import com.ruoyi.guarantee.service.IGuaStorageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/guarantee/storage")
public class GuaStorageController extends BaseController
{
    @Autowired
    private IGuaStorageService guaStorageService;

    /**
     * 查询仓库信息列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:storage:list')")
    @GetMapping("/list")
    public TableDataInfo list(GuaStorage guaStorage)
    {
        startPage();
        List<GuaStorage> list = guaStorageService.selectGuaStorageList(guaStorage);
        return getDataTable(list);
    }

    /**
     * 导出仓库信息列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:storage:export')")
    @Log(title = "仓库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GuaStorage guaStorage)
    {
        List<GuaStorage> list = guaStorageService.selectGuaStorageList(guaStorage);
        ExcelUtil<GuaStorage> util = new ExcelUtil<GuaStorage>(GuaStorage.class);
        util.exportExcel(response, list, "仓库信息数据");
    }

    /**
     * 获取仓库信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:storage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(guaStorageService.selectGuaStorageById(id));
    }

    /**
     * 新增仓库信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:storage:add')")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GuaStorage guaStorage)
    {
        return toAjax(guaStorageService.insertGuaStorage(guaStorage));
    }

    /**
     * 修改仓库信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:storage:edit')")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GuaStorage guaStorage)
    {
        return toAjax(guaStorageService.updateGuaStorage(guaStorage));
    }

    /**
     * 删除仓库信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:storage:remove')")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(guaStorageService.deleteGuaStorageByIds(ids));
    }
}
