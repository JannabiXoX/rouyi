package com.ruoyi.guarantee.mapper;

import java.util.List;
import com.ruoyi.guarantee.domain.GuaGoods;

/**
 * 物资信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface GuaGoodsMapper 
{
    /**
     * 查询物资信息
     * 
     * @param id 物资信息主键
     * @return 物资信息
     */
    public GuaGoods selectGuaGoodsById(Long id);

    /**
     * 查询物资信息列表
     * 
     * @param guaGoods 物资信息
     * @return 物资信息集合
     */
    public List<GuaGoods> selectGuaGoodsList(GuaGoods guaGoods);

    /**
     * 新增物资信息
     * 
     * @param guaGoods 物资信息
     * @return 结果
     */
    public int insertGuaGoods(GuaGoods guaGoods);

    /**
     * 修改物资信息
     * 
     * @param guaGoods 物资信息
     * @return 结果
     */
    public int updateGuaGoods(GuaGoods guaGoods);

    /**
     * 删除物资信息
     * 
     * @param id 物资信息主键
     * @return 结果
     */
    public int deleteGuaGoodsById(Long id);

    /**
     * 批量删除物资信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGuaGoodsByIds(Long[] ids);
}
