package com.ruoyi.guarantee.service;

import java.util.List;
import com.ruoyi.guarantee.domain.GuaApply;

/**
 * 物资调用申请记录Service接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface IGuaApplyService 
{
    /**
     * 查询物资调用申请记录
     * 
     * @param id 物资调用申请记录主键
     * @return 物资调用申请记录
     */
    public GuaApply selectGuaApplyById(Long id);

    /**
     * 查询物资调用申请记录列表
     * 
     * @param guaApply 物资调用申请记录
     * @return 物资调用申请记录集合
     */
    public List<GuaApply> selectGuaApplyList(GuaApply guaApply);

    /**
     * 新增物资调用申请记录
     * 
     * @param guaApply 物资调用申请记录
     * @return 结果
     */
    public int insertGuaApply(GuaApply guaApply);

    /**
     * 修改物资调用申请记录
     * 
     * @param guaApply 物资调用申请记录
     * @return 结果
     */
    public int updateGuaApply(GuaApply guaApply);

    /**
     * 批量删除物资调用申请记录
     * 
     * @param ids 需要删除的物资调用申请记录主键集合
     * @return 结果
     */
    public int deleteGuaApplyByIds(Long[] ids);

    /**
     * 删除物资调用申请记录信息
     * 
     * @param id 物资调用申请记录主键
     * @return 结果
     */
    public int deleteGuaApplyById(Long id);
}
