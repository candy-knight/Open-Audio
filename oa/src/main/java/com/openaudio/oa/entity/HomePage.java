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
@TableName("tb_home_page")
public class HomePage {

    /**
     * 首页图片id
     */
    @TableId(value = "homePageID", type = IdType.AUTO)
    private Integer homePageID;

    /**
     * 页面名字
     */
    private String pageName;

    /**
     * 页面图片地址
     */
    private String pageCover;

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
