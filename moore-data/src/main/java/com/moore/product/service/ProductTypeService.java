package com.moore.product.service;

import com.moore.product.model.vo.SeriesTypeVo;
import com.moore.product.model.vo.SeriesVo;

import java.util.List;

public interface ProductTypeService {

    List<SeriesVo> getProductTypeMenu();
}
