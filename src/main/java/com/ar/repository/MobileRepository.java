package com.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ar.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long>{

}
