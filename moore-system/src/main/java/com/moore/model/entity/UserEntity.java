package com.moore.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("moore_user")
public class UserEntity implements Serializable {

    @TableId("user_id")
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("user_password")
    private String password;

    @TableField("user_netname")
    private String netName;

    @TableField("user_role")
    private String userRole;

    @TableField("user_photo")
    private String userPhoto;
}
