package com.moore.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moore.common.utils.BeanUtil;
import com.moore.product.mapper.SubjectMapper;
import com.moore.product.model.entity.SubjectEntity;
import com.moore.product.model.vo.SubjectVo;
import com.moore.product.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<SubjectVo> getPutStorageType() {
        QueryWrapper<SubjectEntity> wrapper = new QueryWrapper<SubjectEntity>().eq("treeID", "1");
        List<SubjectEntity> entities = subjectMapper.selectList(wrapper);
        List<SubjectVo> entityList = BeanUtil.copyList(entities, SubjectVo.class);
        List<SubjectVo> list = getSonNode(entityList);
        return list;
    }

    private List<SubjectVo> getSonNode(List<SubjectVo> entities) {
        entities.forEach(e -> {
            String treeId = e.getTreeId();
            QueryWrapper<SubjectEntity> wrapper = new QueryWrapper<SubjectEntity>().eq("parentID", treeId);
            List<SubjectEntity> entityList = subjectMapper.selectList(wrapper);
            List<SubjectVo> list = BeanUtil.copyList(entityList, SubjectVo.class);
            if (!list.isEmpty()) {
                e.setChildNode(list);
                getSonNode(list);
            }
        });
        return entities;
    }
}
