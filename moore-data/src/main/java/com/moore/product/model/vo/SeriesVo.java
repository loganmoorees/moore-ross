package com.moore.product.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeriesVo implements Serializable {

    private String seriesId;

    private String treeId;

    private String name;

    private String isModify;

    private String finSeriesId;

    private Byte isQuo;

    private String matClass;

    private List<SeriesVo> childMenu;
}
