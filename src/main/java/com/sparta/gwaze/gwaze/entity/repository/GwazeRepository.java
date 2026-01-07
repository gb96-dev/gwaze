package com.sparta.gwaze.gwaze.repository;

import com.sparta.gwaze.gwaze.entity.Gwaze;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GwazeRepository extends JpaRepository<Gwaze, Long> {
}