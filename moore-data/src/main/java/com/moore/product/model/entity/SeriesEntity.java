package com.moore.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("series")
public class SeriesEntity {

    @TableId(value = "seriesId", type = IdType.INPUT)
    private String seriesId;

    @TableField("treeId")
    private String treeId;

    @TableField("name")
    private String name;

    @TableField("des")
    private String des;

    @TableField("operator")
    private String operator;

    @TableField("editDate")
    private Date editDate;

    @TableField("isModify")
    private String isModify;

    @TableField("finSeriesId")
    private String finSeriesId;

    @TableField("poPeriod")
    private Integer poPeriod;

    @TableField("isQuo")
    private Byte isQuo;

    @TableField("smallType")
    private String smallType;

    @TableField("bigType")
    private String bigType;

    @TableField("matClass")
    private String matClass;

    @TableField("gtm")
    private Double gtm;

    @TableField("sizeGroupId")
    private String sizeGroupId;

    @TableField("sizeGroupNm")
    private String sizeGroupNm;

    @TableField("sizeSeriesId")
    private String sizeSeriesId;

    @TableField("sizeSeriesNm")
    private String sizeSeriesNm;

    @TableField("subjectId")
    private String subjectId;

    @TableField("storageTacticsId")
    private String storageTacticsId;

    @TableField("parentId")
    private String parentId;
}
