package com.sparta.spring_week01.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HanghaeRepository extends JpaRepository<Hanghae, Long> {
      List<Hanghae> findAllByOrderByModifiedAtDesc();
    // 수정날짜순으로 내림차순 정렬
}

//@query("select