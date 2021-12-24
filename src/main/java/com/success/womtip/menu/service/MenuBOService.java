package com.success.womtip.menu.service;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
@Service
public class MenuBOService {

    private final MenuRepository menuRepository;

    public MenuBOService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> retrieveMenu(String menuNm, Boolean blindYn){
        if(!ObjectUtils.isEmpty(menuNm)&&!"".equals(menuNm)&& blindYn!=null){
          return menuRepository.findMenusByMenuNmContainsAndBlindYnOrderByOrder(menuNm,blindYn);
        }else if(!ObjectUtils.isEmpty(menuNm)&&!"".equals(menuNm)){
            return menuRepository.findMenusByMenuNmContainingOrderByOrder(menuNm);
        }else if(blindYn!=null){
            return menuRepository.findMenusByBlindYnOrderByOrder(blindYn);
        }
        return menuRepository.findAll(Sort.by(Sort.Direction.ASC,"order"));
    }



    public boolean createMenu(Menu menu) {
        boolean result = false;
        Menu resultEntity = menuRepository.save(menu);
        if (!ObjectUtils.isEmpty(resultEntity)) result = true;

        return result;
    }

    public boolean updateMenu(Menu menu) {
        boolean result = false;
        Menu found = menuRepository.getById(menu.getMenuCd());
        if (found.getMenuCd()!=null) {
            menuRepository.save(menu);
            result = true;
        }

        return result;
    }

    public boolean deleteMenu(Long menuCd) {
        boolean result = false;
        Menu found = menuRepository.getById(menuCd);
        if (!ObjectUtils.isEmpty(found)) {
            menuRepository.deleteById(menuCd);
            result = true;
        }
        return result;

    }
}