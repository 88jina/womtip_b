package com.success.womtip.menu.controller;

import com.success.womtip.entity.Menu;
import com.success.womtip.menu.service.MenuBOService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bo/menu")
public class MenuBOController {

    private final MenuBOService menuBOService;

    public MenuBOController(MenuBOService menuBOService) {
        this.menuBOService = menuBOService;
    }

    @GetMapping
    public List<Menu> retrieveMenu(@RequestParam(required = false) String menuNm, @RequestParam(required = false) Boolean blindYn) {
        return menuBOService.retrieveMenu(menuNm, blindYn);
    }


    @PostMapping
    public ResponseEntity<Void> createMenu(@RequestBody Menu menu) {
        boolean result = menuBOService.createMenu(menu);
        if (!result) return new ResponseEntity<>(HttpStatus.CONFLICT);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateMenu(@RequestBody Menu menu) {
        boolean result = menuBOService.updateMenu(menu);
        if (!result) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMenu(@RequestParam Long menuCd) {
        boolean result = menuBOService.deleteMenu(menuCd);
        if (!result) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
