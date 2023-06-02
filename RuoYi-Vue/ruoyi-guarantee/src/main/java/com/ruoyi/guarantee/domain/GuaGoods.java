package com.ruoyi.guarantee.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资信息对象 gua_goods
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class GuaGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 货物id */
    private Long id;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String name;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long storage;

    /** 货物分类id */
    @Excel(name = "货物分类id")
    private Long goodsType;

    /** 货物数量 */
    @Excel(name = "货物数量")
    private Long count;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStorage(Long storage) 
    {
        this.storage = storage;
    }

    public Long getStorage() 
    {
        return storage;
    }
    public void setGoodsType(Long goodsType) 
    {
        this.goodsType = goodsType;
    }

    public Long getGoodsType() 
    {
        return goodsType;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("storage", getStorage())
            .append("goodsType", getGoodsType())
            .append("count", getCount())
            .append("remark", getRemark())
            .toString();
    }
}
