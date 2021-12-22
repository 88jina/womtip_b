package com.success.womtip.menu.repository;

import com.success.womtip.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    List<Menu> findMenusByMenuNmContainsAndShowYnOrderByOrder(String menuNm,boolean showYn);
    List<Menu> findMenusByMenuNmContainingOrderByOrder(String menuNm);
    List<Menu> findMenusByShowYnOrderByOrder(boolean showYn);

}
