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
@TableName("tb_photo")
public class Photo {

    /**
     * 相片id
     */
    @TableId(value = "photoID", type = IdType.AUTO)
    private Integer photoID;

    /**
     * 所对相簿id
     */
    private Integer albumId;

    /**
     * 相片名
     */
    private String photoName;

    /**
     * 相片描述
     */
    private String photoDesc;

    /**
     * 相片地址
     */
    private String photoSrc;

    /**
     * 是否删除
     */
    private Integer isDelete;


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
