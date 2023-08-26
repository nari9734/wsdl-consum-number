package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Number;

public interface NumberRepository extends JpaRepository<Number, Integer>{

}
