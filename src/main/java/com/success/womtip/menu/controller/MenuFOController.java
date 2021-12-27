package com.success.womtip.menu.controller;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.service.MenuFOService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fo/menu")
public class MenuFOController {

    private final MenuFOService menuFOService;

    public MenuFOController(MenuFOService menuFOService) {
        this.menuFOService = menuFOService;
    }

    @GetMapping
    public List<Menu> retrieveMenu(){
        return menuFOService.retrieveMenu();
    }
}
