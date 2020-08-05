package com.moore.product.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("series_type")
public class SeriesTypeEntity {

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;
}
