package com.success.womtip.spec;

import com.success.womtip.entity.Board;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BoardSpecs {


public static Specification<Board> boardNmLike(final String boardNm){
    return new Specification<Board>() {
        @Override
        public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


            return null;
        }
    };

    }

}
