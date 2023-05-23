package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.OrEvent;
import com.ruoyi.system.mapper.OrEventMapper;
import com.ruoyi.system.service.IOrEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 应急事件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
@Service
public class OrEventServiceImpl implements IOrEventService
{
    @Autowired
    private OrEventMapper orEventMapper;

    /**
     * 查询应急事件
     * 
     * @param id 应急事件主键
     * @return 应急事件
     */
    @Override
    public OrEvent selectOrEventById(Long id)
    {
        return orEventMapper.selectOrEventById(id);
    }

    /**
     * 查询应急事件列表
     * 
     * @param orEvent 应急事件
     * @return 应急事件
     */
    @Override
    public List<OrEvent> selectOrEventList(OrEvent orEvent)
    {
        return orEventMapper.selectOrEventList(orEvent);
    }

    /**
     * 新增应急事件
     * 
     * @param orEvent 应急事件
     * @return 结果
     */
    @Override
    public int insertOrEvent(OrEvent orEvent)
    {
        return orEventMapper.insertOrEvent(orEvent);
    }

    /**
     * 修改应急事件
     * 
     * @param orEvent 应急事件
     * @return 结果
     */
    @Override
    public int updateOrEvent(OrEvent orEvent)
    {
        return orEventMapper.updateOrEvent(orEvent);
    }

    /**
     * 批量删除应急事件
     * 
     * @param ids 需要删除的应急事件主键
     * @return 结果
     */
    @Override
    public int deleteOrEventByIds(Long[] ids)
    {
        return orEventMapper.deleteOrEventByIds(ids);
    }

    /**
     * 删除应急事件信息
     * 
     * @param id 应急事件主键
     * @return 结果
     */
    @Override
    public int deleteOrEventById(Long id)
    {
        return orEventMapper.deleteOrEventById(id);
    }
}
