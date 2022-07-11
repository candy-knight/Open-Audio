package com.openaudio.oa.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_user")
public class User {

    /**
     * 用户id编号
     */
    @TableId(value = "UUID")
    private String UUID;

    /**
     * 账号
     */
    private String account;

    /**
     *  账号密码
     */
    private String accountPassword;

    /**
     * 用户身份-0超级管理员 1 管理员
     */
    private Integer identity;

    /**
     * 登录类型
     */
    private Integer loginType;

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

    /**
     * 最近登录时间
     */
    private LocalDateTime lastLoginTime;
}
