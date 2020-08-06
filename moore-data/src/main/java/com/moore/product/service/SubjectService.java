package com.moore.product.service;

import com.moore.product.model.vo.SubjectVo;

import java.util.List;

public interface SubjectService {

    /**
     * 入库科目类别菜单
     *
     * @return
     */
    List<SubjectVo> getPutStorageType();

}
