package com.moore.product.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class SeriesTypeVo implements Serializable {

    private static final long serialVersionUID = 7930639286482936960L;

    @ApiModelProperty("编号")
    private String code;

    @ApiModelProperty("名称")
    private String name;
}
