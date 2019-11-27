package com.tenmax.interview.assignment.basic.repository;

import com.tenmax.interview.assignment.basic.domain.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
