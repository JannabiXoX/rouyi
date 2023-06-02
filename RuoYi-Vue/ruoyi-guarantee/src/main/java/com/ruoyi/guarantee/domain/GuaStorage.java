package com.ruoyi.guarantee.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库信息对象 gua_storage
 * 
 * @author ruoyi
 * @date 2023-06-02
 */
public class GuaStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库id */
    private Long id;

    /** 仓库名字 */
    @Excel(name = "仓库名字")
    private String name;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("remark", getRemark())
            .toString();
    }
}
