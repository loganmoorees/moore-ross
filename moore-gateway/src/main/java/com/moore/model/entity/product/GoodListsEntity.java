package com.moore.model.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  Series对象
 *
 * @author Moore
 * @since 2020-07-14
 */
@Data
@TableName("series")
public class GoodListsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "seriesid", type = IdType.INPUT)
    private String seriesid;

    @TableField("treeID")
    private String treeID;

    @TableField("name")
    private String name;

    @TableField("des")
    private String des;

    @TableField("operator")
    private String operator;

    @TableField("editDate")
    private LocalDateTime editdate;

    @TableField("isModify")
    private String isModify;

    @TableField("finSeriesID")
    private String finSeriesID;

    @TableField("poPeriod")
    private Integer poPeriod;

    @TableField("isQuo")
    private Boolean isQuo;

    @TableField("smalltype")
    private String smalltype;

    @TableField("bigtype")
    private String bigtype;

    @TableField("matCLASS")
    private String matCLASS;

    @TableField("gtm")
    private Double gtm;

    @TableField("sizeGroupid")
    private String sizeGroupid;

    @TableField("sizeGroupNM")
    private String sizeGroupNM;

    @TableField("sizeSeriesID")
    private String sizeSeriesID;

    @TableField("sizeSeriesNM")
    private String sizeSeriesNM;

    @TableField("subjectID")
    private String subjectID;

    @TableField("storageTacticsID")
    private String storageTacticsID;

}
