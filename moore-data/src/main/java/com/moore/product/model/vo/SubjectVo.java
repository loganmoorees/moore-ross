package com.moore.product.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 采购入库科目类别
 *
 * @author Moore
 * @date 2020-08-06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectVo implements Serializable {

    private String treeId;

    private String name;

    private String type;

    private String des;

    private List<SubjectVo> childNode;
}