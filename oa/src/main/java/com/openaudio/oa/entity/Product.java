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
@TableName("tb_product")
public class Product {

    /**
     * 产品id
     */
    @TableId(value = "productID", type = IdType.AUTO)
    private Integer productID;

    /**
     * 产品分类
     */
    private Integer productCategory;

    /**
     * 产品缩略图地址
     */
    private String productCover;

    /**
     * 背景图片地址
     */
    private String backgroundImage;

    /**
     * 产品标题
     */
    private String productTitle;

    /**
     * 产品内容
     */
    private String productContent;

    /**
     * 购物连接
     */
    private String shoppingUrl;

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
