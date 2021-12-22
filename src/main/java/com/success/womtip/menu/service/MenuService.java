package com.success.womtip.menu.service;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository=menuRepository;
    }

    public boolean createMenu(Menu menu){
        boolean result = false;
        Menu resultEntity = menuRepository.save(menu);
        if(!ObjectUtils.isEmpty(resultEntity)) result=true;

        return result;
    }

}
