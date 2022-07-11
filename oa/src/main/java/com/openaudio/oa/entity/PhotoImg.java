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
@TableName("tb_product_img")
public class PhotoImg {
    /**
     * 产品图片id
     */
    @TableId(value = "productImageID" , type = IdType.AUTO)
    private Integer productImageID;

    /**
     * 对应的产品id
     */
    private Integer productId;

    /**
     * 产品页面的背景图片
     */
    private String productBackgroundImage;

    /**
     * 产品页面标题内容
     */
    private String productTitle;

    /**
     * 产品页面内容
     */
    private String productText;

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
