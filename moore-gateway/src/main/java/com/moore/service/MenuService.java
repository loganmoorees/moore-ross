package com.moore.service;

import com.moore.model.vo.MenuVO;

import java.util.List;

public interface MenuService {

    /**
     * 获取菜单
     *
     * @return
     */
    List<MenuVO> menu();
}
