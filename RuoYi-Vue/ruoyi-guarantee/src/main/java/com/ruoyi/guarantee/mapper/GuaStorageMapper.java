package com.ruoyi.guarantee.mapper;

import java.util.List;
import com.ruoyi.guarantee.domain.GuaStorage;

/**
 * 仓库信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public interface GuaStorageMapper 
{
    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    public GuaStorage selectGuaStorageById(Long id);

    /**
     * 查询仓库信息列表
     * 
     * @param guaStorage 仓库信息
     * @return 仓库信息集合
     */
    public List<GuaStorage> selectGuaStorageList(GuaStorage guaStorage);

    /**
     * 新增仓库信息
     * 
     * @param guaStorage 仓库信息
     * @return 结果
     */
    public int insertGuaStorage(GuaStorage guaStorage);

    /**
     * 修改仓库信息
     * 
     * @param guaStorage 仓库信息
     * @return 结果
     */
    public int updateGuaStorage(GuaStorage guaStorage);

    /**
     * 删除仓库信息
     * 
     * @param id 仓库信息主键
     * @return 结果
     */
    public int deleteGuaStorageById(Long id);

    /**
     * 批量删除仓库信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGuaStorageByIds(Long[] ids);
}
