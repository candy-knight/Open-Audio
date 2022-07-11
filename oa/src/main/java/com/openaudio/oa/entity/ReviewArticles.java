package com.openaudio.oa.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 评测文章
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_review_articles")
public class ReviewArticles {

    /**
     * 文章id
     */
    @TableId(value = "reviewArticlesID", type = IdType.AUTO)
    private Integer reviewArticlesID;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 作者头像
     */
    private String authorAvatar;

    /**
     * 文章分类
     */
    private Integer categoryId;

    /**
     * 文章对应产品id
     */
    private Integer productId;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 标题图片
     */
    private String titleImage;

    /**
     * 标题
     */
    private String articleTitle;

    /**
     * 内容
     */
    private String articleContent;

    /**
     * 状态值
     * 1公开
     * 2私密
     * 3草稿
     */
    private Integer status;

    /**
     * 原文连接
     */
    private String originalUrl;

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
