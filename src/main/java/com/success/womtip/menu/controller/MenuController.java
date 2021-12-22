package com.success.womtip.menu.controller;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> retrieveMenu(@RequestParam(required = false) String menuNm, @RequestParam(required = false) Boolean showYn) {
        return menuService.retrieveMenu(menuNm, showYn);
    }


    @PostMapping
    public ResponseEntity<Void> createMenu(@RequestBody Menu menu) {
        boolean result = menuService.createMenu(menu);
        if (!result) return new ResponseEntity<>(HttpStatus.CONFLICT);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateMenu(@RequestBody Menu menu) {
        boolean result = menuService.updateMenu(menu);
        if (!result) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMenu(@RequestParam Long menuCd) {
        boolean result = menuService.deleteMenu(menuCd);
        if (!result) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
