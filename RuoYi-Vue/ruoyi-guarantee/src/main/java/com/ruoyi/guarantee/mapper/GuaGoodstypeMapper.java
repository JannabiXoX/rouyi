package com.ruoyi.guarantee.mapper;

import java.util.List;
import com.ruoyi.guarantee.domain.GuaGoodstype;

/**
 * 货物类型信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface GuaGoodstypeMapper 
{
    /**
     * 查询货物类型信息
     * 
     * @param id 货物类型信息主键
     * @return 货物类型信息
     */
    public GuaGoodstype selectGuaGoodstypeById(Long id);

    /**
     * 查询货物类型信息列表
     * 
     * @param guaGoodstype 货物类型信息
     * @return 货物类型信息集合
     */
    public List<GuaGoodstype> selectGuaGoodstypeList(GuaGoodstype guaGoodstype);

    /**
     * 新增货物类型信息
     * 
     * @param guaGoodstype 货物类型信息
     * @return 结果
     */
    public int insertGuaGoodstype(GuaGoodstype guaGoodstype);

    /**
     * 修改货物类型信息
     * 
     * @param guaGoodstype 货物类型信息
     * @return 结果
     */
    public int updateGuaGoodstype(GuaGoodstype guaGoodstype);

    /**
     * 删除货物类型信息
     * 
     * @param id 货物类型信息主键
     * @return 结果
     */
    public int deleteGuaGoodstypeById(Long id);

    /**
     * 批量删除货物类型信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGuaGoodstypeByIds(Long[] ids);
}
