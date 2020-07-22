package com.moore.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("moore_menu")
public class MenuEntity {

    @TableId("menu_id")
    private Integer menuId;

    @TableField("menu_name")
    private String menuName;

    @TableField("menu_parent")
    private Integer menuParent;

    @TableField("menu_path")
    private String menuPath;

}
