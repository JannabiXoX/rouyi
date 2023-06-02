package com.ruoyi.guarantee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guarantee.mapper.GuaStorageMapper;
import com.ruoyi.guarantee.domain.GuaStorage;
import com.ruoyi.guarantee.service.IGuaStorageService;

/**
 * 仓库信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
@Service
public class GuaStorageServiceImpl implements IGuaStorageService 
{
    @Autowired
    private GuaStorageMapper guaStorageMapper;

    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    @Override
    public GuaStorage selectGuaStorageById(Long id)
    {
        return guaStorageMapper.selectGuaStorageById(id);
    }

    /**
     * 查询仓库信息列表
     * 
     * @param guaStorage 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<GuaStorage> selectGuaStorageList(GuaStorage guaStorage)
    {
        return guaStorageMapper.selectGuaStorageList(guaStorage);
    }

    /**
     * 新增仓库信息
     * 
     * @param guaStorage 仓库信息
     * @return 结果
     */
    @Override
    public int insertGuaStorage(GuaStorage guaStorage)
    {
        return guaStorageMapper.insertGuaStorage(guaStorage);
    }

    /**
     * 修改仓库信息
     * 
     * @param guaStorage 仓库信息
     * @return 结果
     */
    @Override
    public int updateGuaStorage(GuaStorage guaStorage)
    {
        return guaStorageMapper.updateGuaStorage(guaStorage);
    }

    /**
     * 批量删除仓库信息
     * 
     * @param ids 需要删除的仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteGuaStorageByIds(Long[] ids)
    {
        return guaStorageMapper.deleteGuaStorageByIds(ids);
    }

    /**
     * 删除仓库信息信息
     * 
     * @param id 仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteGuaStorageById(Long id)
    {
        return guaStorageMapper.deleteGuaStorageById(id);
    }
}
