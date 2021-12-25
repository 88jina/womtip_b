package com.success.womtip.menu.repository.spec;

import com.success.womtip.entity.Menu;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class MenuSpecs {
    public static Specification<Menu> equalBlindYn(Boolean blindYn) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("blindYn"), blindYn));
    }

    public static Specification<Menu> delYnAndOrder(Boolean delYn) {
        return ((root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("order")));
           return criteriaBuilder.equal(root.get("delYn"),delYn);
        });
    }

    public static Specification<Menu> likeMenuNm(String menuNm) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("menuNm"), "%" + menuNm + "%"));
    }
}
