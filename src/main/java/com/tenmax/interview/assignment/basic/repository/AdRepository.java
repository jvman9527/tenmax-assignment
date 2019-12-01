package com.tenmax.interview.assignment.basic.repository;

import com.tenmax.interview.assignment.basic.domain.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long>, CustomizedAdRepository {

    Page<Ad> findByTitleContaining(String keyword, Pageable pageable);

}

