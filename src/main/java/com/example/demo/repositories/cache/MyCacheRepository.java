package com.example.demo.repositories.cache;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CacheEntry;

@Repository
public interface MyCacheRepository extends CrudRepository<CacheEntry, String> {

}
