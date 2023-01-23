package com.drugstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drugstore.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
