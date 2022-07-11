package com.openaudio.oa.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_agent_info")
public class AgentInfo {

    /**
     * 代理商id
     */
    @TableId(value = "AgentInfoID", type = IdType.AUTO)
    private Integer agentInfoID;

    /**
     * 代理商名称
     */
    private String agentName;

    /**
     * 代理商电话
     */
    private String agentTelephone;

    /**
     * 代理商地址
     */
    private String agentAddress;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}
