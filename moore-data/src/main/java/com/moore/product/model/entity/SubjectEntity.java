package com.moore.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("`subject`")
public class SubjectEntity {

    @TableId(value = "subjectId", type = IdType.INPUT)
    private String subjectId;

    @TableField("treeId")
    private String treeId;

    @TableField("name")
    private String name;

    @TableField("type")
    private String type;

    @TableField("coinId")
    private String coinId;

    @TableField("des")
    private String des;

    @TableField("isLedgerLast")
    private Integer isLedgerLast;

    @TableField("isListLast")
    private Integer isListLast;

    @TableField("beginTotal")
    private BigDecimal beginTotal;

    @TableField("debitTotal")
    private BigDecimal debitTotal;

    @TableField("lenderTotal")
    private BigDecimal lenderTotal;

    @TableField("endTotal")
    private BigDecimal endTotal;

    @TableField("operator")
    private String operator;

    @TableField("editdate")
    private Date editdate;

    @TableField("beginMonth")
    private String beginMonth;

    @TableField("state")
    private String state;

    @TableField("isSum")
    private Integer isSum;

    @TableField("yearDebit")
    private BigDecimal yearDebit;

    @TableField("yearLender")
    private BigDecimal yearLender;

    @TableField("debitTotal1")
    private BigDecimal debitTotal1;

    @TableField("lenderTotal1")
    private BigDecimal lenderTotal1;

    @TableField("yearDebit1")
    private BigDecimal yearDebit1;

    @TableField("yearLender1")
    private BigDecimal yearLender1;

    @TableField("ledgerID")
    private String ledgerID;

    @TableField("subjectID1")
    private String subjectID1;

    @TableField("subjectID2")
    private String subjectID2;

    @TableField("subjectID3")
    private String subjectID3;

    @TableField("subjectID4")
    private String subjectID4;

    @TableField("currencyID")
    private String currencyID;

    @TableField("parentId")
    private String parentId;
}
