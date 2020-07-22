package com.moore.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {

    private Integer menuId;

    private String menuName;

    private Integer menuParent;

    private String menuPath;

    private List<MenuVO> childMenus;
}
