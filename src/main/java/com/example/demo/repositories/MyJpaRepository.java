package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.SimpleEntry;

@Repository
public interface MyJpaRepository extends JpaRepository<SimpleEntry, Integer> {

}
