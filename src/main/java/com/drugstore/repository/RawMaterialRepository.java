package com.drugstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drugstore.entities.Client;
import com.drugstore.entities.RawMaterial;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {

}
