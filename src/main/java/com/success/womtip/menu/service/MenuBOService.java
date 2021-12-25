package com.success.womtip.menu.service;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.repository.MenuRepository;
import com.success.womtip.menu.repository.spec.MenuSpecs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class MenuBOService {

    private final MenuRepository menuRepository;

    public MenuBOService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> retrieveMenu(String menuNm, Boolean blindYn) {
        Specification<Menu> spec = Specification.where(MenuSpecs.delYnAndOrder(false));
        if (menuNm != null) spec = spec.and(MenuSpecs.likeMenuNm(menuNm));
        spec = spec.and(MenuSpecs.equalBlindYn(Objects.requireNonNullElse(blindYn, false)));

        return menuRepository.findAll(spec);
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
        if (found.getMenuCd() != null) {
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
