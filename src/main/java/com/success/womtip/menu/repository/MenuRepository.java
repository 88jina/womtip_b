package com.success.womtip.menu.repository;

import com.success.womtip.entity.Menu;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> , JpaSpecificationExecutor<Menu> {
    @Override
    @NonNull
    List<Menu> findAll(Specification<Menu> spec);
}
