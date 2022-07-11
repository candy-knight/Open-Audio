package com.openaudio.oa.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 轮播图
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_swiper_picture")
public class Swipe {

    /**
     * 轮播图id
     */
    @TableId(value = "swiperID", type = IdType.AUTO)
    private Integer swiperID;

    /**
     * 轮播图图片地址
     */
    private String swiperImageUrl;

    /**
     * 轮播图缩略图地址
     */
    private String swiperImageCover;

    /**
     * 轮播图点击后跳转地址
     */
    private String swiperImageJumpUrl;

    /**
     * 是否展示
     */
    private Integer isShow;

    /**
     * 轮播图排序
     */
    private Integer sort;

    /**
     * 轮播图对应产品id
     */
    private Integer productId;

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
