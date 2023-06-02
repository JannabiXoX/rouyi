package com.ruoyi.guarantee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guarantee.mapper.GuaApplyMapper;
import com.ruoyi.guarantee.domain.GuaApply;
import com.ruoyi.guarantee.service.IGuaApplyService;

/**
 * 物资调用申请记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class GuaApplyServiceImpl implements IGuaApplyService 
{
    @Autowired
    private GuaApplyMapper guaApplyMapper;

    /**
     * 查询物资调用申请记录
     * 
     * @param id 物资调用申请记录主键
     * @return 物资调用申请记录
     */
    @Override
    public GuaApply selectGuaApplyById(Long id)
    {
        return guaApplyMapper.selectGuaApplyById(id);
    }

    /**
     * 查询物资调用申请记录列表
     * 
     * @param guaApply 物资调用申请记录
     * @return 物资调用申请记录
     */
    @Override
    public List<GuaApply> selectGuaApplyList(GuaApply guaApply)
    {
        return guaApplyMapper.selectGuaApplyList(guaApply);
    }

    /**
     * 新增物资调用申请记录
     * 
     * @param guaApply 物资调用申请记录
     * @return 结果
     */
    @Override
    public int insertGuaApply(GuaApply guaApply)
    {
        return guaApplyMapper.insertGuaApply(guaApply);
    }

    /**
     * 修改物资调用申请记录
     * 
     * @param guaApply 物资调用申请记录
     * @return 结果
     */
    @Override
    public int updateGuaApply(GuaApply guaApply)
    {
        return guaApplyMapper.updateGuaApply(guaApply);
    }

    /**
     * 批量删除物资调用申请记录
     * 
     * @param ids 需要删除的物资调用申请记录主键
     * @return 结果
     */
    @Override
    public int deleteGuaApplyByIds(Long[] ids)
    {
        return guaApplyMapper.deleteGuaApplyByIds(ids);
    }

    /**
     * 删除物资调用申请记录信息
     * 
     * @param id 物资调用申请记录主键
     * @return 结果
     */
    @Override
    public int deleteGuaApplyById(Long id)
    {
        return guaApplyMapper.deleteGuaApplyById(id);
    }
}
