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
import com.ruoyi.guarantee.domain.GuaGoodstype;
import com.ruoyi.guarantee.service.IGuaGoodstypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货物类型信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@RestController
@RequestMapping("/guarantee/goodstype")
public class GuaGoodstypeController extends BaseController
{
    @Autowired
    private IGuaGoodstypeService guaGoodstypeService;

    /**
     * 查询货物类型信息列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goodstype:list')")
    @GetMapping("/list")
    public TableDataInfo list(GuaGoodstype guaGoodstype)
    {
        startPage();
        List<GuaGoodstype> list = guaGoodstypeService.selectGuaGoodstypeList(guaGoodstype);
        return getDataTable(list);
    }

    /**
     * 导出货物类型信息列表
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goodstype:export')")
    @Log(title = "货物类型信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GuaGoodstype guaGoodstype)
    {
        List<GuaGoodstype> list = guaGoodstypeService.selectGuaGoodstypeList(guaGoodstype);
        ExcelUtil<GuaGoodstype> util = new ExcelUtil<GuaGoodstype>(GuaGoodstype.class);
        util.exportExcel(response, list, "货物类型信息数据");
    }

    /**
     * 获取货物类型信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goodstype:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(guaGoodstypeService.selectGuaGoodstypeById(id));
    }

    /**
     * 新增货物类型信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goodstype:add')")
    @Log(title = "货物类型信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GuaGoodstype guaGoodstype)
    {
        return toAjax(guaGoodstypeService.insertGuaGoodstype(guaGoodstype));
    }

    /**
     * 修改货物类型信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goodstype:edit')")
    @Log(title = "货物类型信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GuaGoodstype guaGoodstype)
    {
        return toAjax(guaGoodstypeService.updateGuaGoodstype(guaGoodstype));
    }

    /**
     * 删除货物类型信息
     */
    @PreAuthorize("@ss.hasPermi('guarantee:goodstype:remove')")
    @Log(title = "货物类型信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(guaGoodstypeService.deleteGuaGoodstypeByIds(ids));
    }
}
