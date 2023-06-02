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
import com.ruoyi.guarantee.domain.GuaGoods;
import com.ruoyi.guarantee.service.IGuaGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物资信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/guarantee/goods")
public class GuaGoodsController extends BaseController
{
    @Autowired
    private IGuaGoodsService guaGoodsService;

    /**
     * 查询物资信息列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(GuaGoods guaGoods)
    {
        startPage();
        List<GuaGoods> list = guaGoodsService.selectGuaGoodsList(guaGoods);
        return getDataTable(list);
    }

    /**
     * 导出物资信息列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goods:export')")
    @Log(title = "物资信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GuaGoods guaGoods)
    {
        List<GuaGoods> list = guaGoodsService.selectGuaGoodsList(guaGoods);
        ExcelUtil<GuaGoods> util = new ExcelUtil<GuaGoods>(GuaGoods.class);
        util.exportExcel(response, list, "物资信息数据");
    }

    /**
     * 获取物资信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(guaGoodsService.selectGuaGoodsById(id));
    }

    /**
     * 新增物资信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goods:add')")
    @Log(title = "物资信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GuaGoods guaGoods)
    {
        return toAjax(guaGoodsService.insertGuaGoods(guaGoods));
    }

    /**
     * 修改物资信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goods:edit')")
    @Log(title = "物资信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GuaGoods guaGoods)
    {
        return toAjax(guaGoodsService.updateGuaGoods(guaGoods));
    }

    /**
     * 删除物资信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goods:remove')")
    @Log(title = "物资信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(guaGoodsService.deleteGuaGoodsByIds(ids));
    }
}
