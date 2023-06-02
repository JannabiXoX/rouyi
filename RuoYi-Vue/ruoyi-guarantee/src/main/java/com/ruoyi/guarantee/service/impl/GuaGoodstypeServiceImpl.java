package com.ruoyi.guarantee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guarantee.mapper.GuaGoodstypeMapper;
import com.ruoyi.guarantee.domain.GuaGoodstype;
import com.ruoyi.guarantee.service.IGuaGoodstypeService;

/**
 * 货物类型信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class GuaGoodstypeServiceImpl implements IGuaGoodstypeService 
{
    @Autowired
    private GuaGoodstypeMapper guaGoodstypeMapper;

    /**
     * 查询货物类型信息
     * 
     * @param id 货物类型信息主键
     * @return 货物类型信息
     */
    @Override
    public GuaGoodstype selectGuaGoodstypeById(Long id)
    {
        return guaGoodstypeMapper.selectGuaGoodstypeById(id);
    }

    /**
     * 查询货物类型信息列表
     * 
     * @param guaGoodstype 货物类型信息
     * @return 货物类型信息
     */
    @Override
    public List<GuaGoodstype> selectGuaGoodstypeList(GuaGoodstype guaGoodstype)
    {
        return guaGoodstypeMapper.selectGuaGoodstypeList(guaGoodstype);
    }

    /**
     * 新增货物类型信息
     * 
     * @param guaGoodstype 货物类型信息
     * @return 结果
     */
    @Override
    public int insertGuaGoodstype(GuaGoodstype guaGoodstype)
    {
        return guaGoodstypeMapper.insertGuaGoodstype(guaGoodstype);
    }

    /**
     * 修改货物类型信息
     * 
     * @param guaGoodstype 货物类型信息
     * @return 结果
     */
    @Override
    public int updateGuaGoodstype(GuaGoodstype guaGoodstype)
    {
        return guaGoodstypeMapper.updateGuaGoodstype(guaGoodstype);
    }

    /**
     * 批量删除货物类型信息
     * 
     * @param ids 需要删除的货物类型信息主键
     * @return 结果
     */
    @Override
    public int deleteGuaGoodstypeByIds(Long[] ids)
    {
        return guaGoodstypeMapper.deleteGuaGoodstypeByIds(ids);
    }

    /**
     * 删除货物类型信息信息
     * 
     * @param id 货物类型信息主键
     * @return 结果
     */
    @Override
    public int deleteGuaGoodstypeById(Long id)
    {
        return guaGoodstypeMapper.deleteGuaGoodstypeById(id);
    }
}
