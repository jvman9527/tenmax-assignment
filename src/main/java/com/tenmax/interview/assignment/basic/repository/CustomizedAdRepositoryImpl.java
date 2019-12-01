package com.tenmax.interview.assignment.basic.repository;

import com.tenmax.interview.assignment.basic.domain.Ad;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Ad 客製查詢支援
 */
@Repository
public class CustomizedAdRepositoryImpl implements CustomizedAdRepository {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * 使用隨機位移值取得一筆資料
     * @return Ad 可能為空值
     */
    @Override
    public Ad randomOne() {
        CriteriaQuery<Ad> query = entityManager.getCriteriaBuilder().createQuery(Ad.class);
        return entityManager.createQuery(query.select(query.from(Ad.class)))
                .setFirstResult(randomOffSet())
                .setMaxResults(1)
                .getSingleResult();
    }

    /**
     * @return 隨機位移值，範圍 0 ~ count(*) from table
     */
    private int randomOffSet() {
        CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = queryBuilder.createQuery(Long.class);
        query.select(queryBuilder.count(query.from(Ad.class)));
        Long count = entityManager.createQuery(query).getSingleResult();
        return (int) (Math.random() * count.intValue());
    }

}

