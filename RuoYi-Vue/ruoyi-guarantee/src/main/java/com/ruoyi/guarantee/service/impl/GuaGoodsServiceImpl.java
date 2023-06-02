package com.ruoyi.guarantee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guarantee.mapper.GuaGoodsMapper;
import com.ruoyi.guarantee.domain.GuaGoods;
import com.ruoyi.guarantee.service.IGuaGoodsService;

/**
 * 物资信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class GuaGoodsServiceImpl implements IGuaGoodsService 
{
    @Autowired
    private GuaGoodsMapper guaGoodsMapper;

    /**
     * 查询物资信息
     * 
     * @param id 物资信息主键
     * @return 物资信息
     */
    @Override
    public GuaGoods selectGuaGoodsById(Long id)
    {
        return guaGoodsMapper.selectGuaGoodsById(id);
    }

    /**
     * 查询物资信息列表
     * 
     * @param guaGoods 物资信息
     * @return 物资信息
     */
    @Override
    public List<GuaGoods> selectGuaGoodsList(GuaGoods guaGoods)
    {
        return guaGoodsMapper.selectGuaGoodsList(guaGoods);
    }

    /**
     * 新增物资信息
     * 
     * @param guaGoods 物资信息
     * @return 结果
     */
    @Override
    public int insertGuaGoods(GuaGoods guaGoods)
    {
        return guaGoodsMapper.insertGuaGoods(guaGoods);
    }

    /**
     * 修改物资信息
     * 
     * @param guaGoods 物资信息
     * @return 结果
     */
    @Override
    public int updateGuaGoods(GuaGoods guaGoods)
    {
        return guaGoodsMapper.updateGuaGoods(guaGoods);
    }

    /**
     * 批量删除物资信息
     * 
     * @param ids 需要删除的物资信息主键
     * @return 结果
     */
    @Override
    public int deleteGuaGoodsByIds(Long[] ids)
    {
        return guaGoodsMapper.deleteGuaGoodsByIds(ids);
    }

    /**
     * 删除物资信息信息
     * 
     * @param id 物资信息主键
     * @return 结果
     */
    @Override
    public int deleteGuaGoodsById(Long id)
    {
        return guaGoodsMapper.deleteGuaGoodsById(id);
    }
}
