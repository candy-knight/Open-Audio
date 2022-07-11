package com.openaudio.oa.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_album")
public class Album {

    /**
     * 相簿id
     */
    @TableId(value = "albumID", type = IdType.AUTO)
    private Integer albumID;

    /**
     * 相簿名称
     */
    private String albumName;

    /**
     * 相簿描述
     */
    private String albumDesc;

    /**
     * 相簿缩略图地址
     */
    private String albumCover;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 当前状态
     * 1公开
     * 2私密
     */
    private Integer status;

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
