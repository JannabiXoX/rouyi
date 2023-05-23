package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应急事件对象 or_event
 * 
 * @author ruoyi
 * @date 2023-05-23
 */
public class OrEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件编号 */
    private Long id;

    /** 事件类型 */
    @Excel(name = "事件类型")
    private String type;

    /** 具体事件 */
    @Excel(name = "具体事件")
    private String specific;

    /** 事件发生位置 */
    @Excel(name = "事件发生位置")
    private String position;

    /** 事件内容 */
    @Excel(name = "事件内容")
    private String content;

    /** 上报时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submissionTime;

    /** 时间发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间发生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date incidentTime;

    /** 受伤人数 */
    @Excel(name = "受伤人数")
    private Long injured;

    /** 死亡人数 */
    @Excel(name = "死亡人数")
    private Long dead;

    /** 经济损失 */
    @Excel(name = "经济损失")
    private Long economic;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 现场图片 */
    @Excel(name = "现场图片")
    private String img;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 事件紧急程度 */
    @Excel(name = "事件紧急程度")
    private String urgency;

    /** 影响范围 */
    @Excel(name = "影响范围")
    private String influence;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSpecific(String specific) 
    {
        this.specific = specific;
    }

    public String getSpecific() 
    {
        return specific;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSubmissionTime(Date submissionTime) 
    {
        this.submissionTime = submissionTime;
    }

    public Date getSubmissionTime() 
    {
        return submissionTime;
    }
    public void setIncidentTime(Date incidentTime) 
    {
        this.incidentTime = incidentTime;
    }

    public Date getIncidentTime() 
    {
        return incidentTime;
    }
    public void setInjured(Long injured) 
    {
        this.injured = injured;
    }

    public Long getInjured() 
    {
        return injured;
    }
    public void setDead(Long dead) 
    {
        this.dead = dead;
    }

    public Long getDead() 
    {
        return dead;
    }
    public void setEconomic(Long economic) 
    {
        this.economic = economic;
    }

    public Long getEconomic() 
    {
        return economic;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setUrgency(String urgency) 
    {
        this.urgency = urgency;
    }

    public String getUrgency() 
    {
        return urgency;
    }
    public void setInfluence(String influence) 
    {
        this.influence = influence;
    }

    public String getInfluence() 
    {
        return influence;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("specific", getSpecific())
            .append("position", getPosition())
            .append("content", getContent())
            .append("submissionTime", getSubmissionTime())
            .append("incidentTime", getIncidentTime())
            .append("injured", getInjured())
            .append("dead", getDead())
            .append("economic", getEconomic())
            .append("remarks", getRemarks())
            .append("img", getImg())
            .append("status", getStatus())
            .append("urgency", getUrgency())
            .append("influence", getInfluence())
            .toString();
    }
}
