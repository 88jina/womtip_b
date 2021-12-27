package com.success.womtip.menu.service;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.repository.MenuRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuFOService {
    private final MenuRepository menuRepository;

    public MenuFOService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> retrieveMenu() {
        return menuRepository.findAll(Sort.by(Sort.Direction.ASC,"order"));
    }
}
