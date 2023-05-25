package com.ruoyi.web.controller.organization.domain;

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
 * @date 2023-05-25
 */
public class OrEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件编号 */
    private Long id;

    /** 事件类型 */
    @Excel(name = "事件类型")
    private String eventType;

    /** 具体事件 */
    @Excel(name = "具体事件")
    private String specificEvent;

    /** 发生位置 */
    @Excel(name = "发生位置")
    private String eventPosition;

    /** 事件内容 */
    @Excel(name = "事件内容")
    private String eventContent;

    /** 上报时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submissionTime;

    /** 发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date incidentTime;

    /** 受伤人数 */
    @Excel(name = "受伤人数")
    private Long injuredPerson;

    /** 死亡人数 */
    @Excel(name = "死亡人数")
    private Long deadPerson;

    /** 经济损失 */
    @Excel(name = "经济损失")
    private Double economic;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 现场图片 */
    @Excel(name = "现场图片")
    private String img;

    /** 事件状态 */
    @Excel(name = "事件状态")
    private Long status;

    /** 紧急程度 */
    @Excel(name = "紧急程度")
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
    public void setEventType(String eventType) 
    {
        this.eventType = eventType;
    }

    public String getEventType() 
    {
        return eventType;
    }
    public void setSpecificEvent(String specificEvent) 
    {
        this.specificEvent = specificEvent;
    }

    public String getSpecificEvent() 
    {
        return specificEvent;
    }
    public void setEventPosition(String eventPosition) 
    {
        this.eventPosition = eventPosition;
    }

    public String getEventPosition() 
    {
        return eventPosition;
    }
    public void setEventContent(String eventContent) 
    {
        this.eventContent = eventContent;
    }

    public String getEventContent() 
    {
        return eventContent;
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
    public void setInjuredPerson(Long injuredPerson) 
    {
        this.injuredPerson = injuredPerson;
    }

    public Long getInjuredPerson() 
    {
        return injuredPerson;
    }
    public void setDeadPerson(Long deadPerson) 
    {
        this.deadPerson = deadPerson;
    }

    public Long getDeadPerson() 
    {
        return deadPerson;
    }
    public void setEconomic(Double economic) 
    {
        this.economic = economic;
    }

    public Double getEconomic() 
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
            .append("eventType", getEventType())
            .append("specificEvent", getSpecificEvent())
            .append("eventPosition", getEventPosition())
            .append("eventContent", getEventContent())
            .append("submissionTime", getSubmissionTime())
            .append("incidentTime", getIncidentTime())
            .append("injuredPerson", getInjuredPerson())
            .append("deadPerson", getDeadPerson())
            .append("economic", getEconomic())
            .append("remarks", getRemarks())
            .append("img", getImg())
            .append("status", getStatus())
            .append("urgency", getUrgency())
            .append("influence", getInfluence())
            .toString();
    }
}
