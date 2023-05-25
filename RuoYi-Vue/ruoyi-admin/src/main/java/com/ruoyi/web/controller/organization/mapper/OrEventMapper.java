package com.ruoyi.web.controller.organization.mapper;

import java.util.List;
import com.ruoyi.web.controller.organization.domain.OrEvent;

/**
 * 应急事件Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-25
 */
public interface OrEventMapper 
{
    /**
     * 查询应急事件
     * 
     * @param id 应急事件主键
     * @return 应急事件
     */
    public OrEvent selectOrEventById(Long id);

    /**
     * 查询应急事件列表
     * 
     * @param orEvent 应急事件
     * @return 应急事件集合
     */
    public List<OrEvent> selectOrEventList(OrEvent orEvent);

    /**
     * 新增应急事件
     * 
     * @param orEvent 应急事件
     * @return 结果
     */
    public int insertOrEvent(OrEvent orEvent);

    /**
     * 修改应急事件
     * 
     * @param orEvent 应急事件
     * @return 结果
     */
    public int updateOrEvent(OrEvent orEvent);

    /**
     * 删除应急事件
     * 
     * @param id 应急事件主键
     * @return 结果
     */
    public int deleteOrEventById(Long id);

    /**
     * 批量删除应急事件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrEventByIds(Long[] ids);
}
