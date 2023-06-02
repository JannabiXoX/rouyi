package com.ruoyi.guarantee.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资调用申请记录对象 gua_apply
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class GuaApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序列 */
    private Long id;

    /** 物资id */
    @Excel(name = "物资id")
    private Long goods;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 数量 */
    @Excel(name = "数量")
    private Long count;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoods(Long goods) 
    {
        this.goods = goods;
    }

    public Long getGoods() 
    {
        return goods;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goods", getGoods())
            .append("userId", getUserId())
            .append("count", getCount())
            .append("address", getAddress())
            .toString();
    }
}
