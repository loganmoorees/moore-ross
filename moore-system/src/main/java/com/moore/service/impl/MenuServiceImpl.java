package com.moore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moore.constant.Constant;
import com.moore.mapper.MenuMapper;
import com.moore.model.entity.MenuEntity;
import com.moore.model.vo.MenuVO;
import com.moore.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuVO> menu() {
        // 获取父菜单
        QueryWrapper<MenuEntity> wrapper = new QueryWrapper<MenuEntity>().isNull(Constant.MENU_PARENT);
        List<MenuEntity> menuEntities = menuMapper.selectList(wrapper);
        List<MenuVO> menuVos = entityToVO(menuEntities);

        // 获取子菜单
        List<MenuVO> menu = getSonMenu(menuVos);
        return menu;
    }

    /**
     * 递归获取子菜单
     *
     * @param menuVos
     * @return
     */
    private List<MenuVO> getSonMenu(List<MenuVO> menuVos) {
        menuVos.forEach(e -> {
            QueryWrapper<MenuEntity> queryWrapper = new QueryWrapper<MenuEntity>().eq(Constant.MENU_PARENT, e.getMenuId());
            List<MenuEntity> entities = menuMapper.selectList(queryWrapper);
            if (entities.size() != 0) {
                List<MenuVO> vos = entityToVO(entities);
                e.setChildMenus(vos);
                getSonMenu(e.getChildMenus());
            }
        });
        return menuVos;
    }

    /**
     * 集合转换
     *
     * @param menuEntities
     * @return
     */
    private List<MenuVO> entityToVO(List<MenuEntity> menuEntities) {
        List<MenuVO> menuVos = menuEntities.stream().map(e -> {
            MenuVO menu = MenuVO.builder()
                    .menuId(e.getMenuId())
                    .menuName(e.getMenuName())
                    .menuPath(e.getMenuPath())
                    .menuParent(e.getMenuParent())
                    .build();
            return menu;
        }).collect(Collectors.toList());
        return menuVos;
    }
}
