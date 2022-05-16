
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.SimpleEntry;
import com.example.demo.entities.CacheEntry;
import com.example.demo.repositories.MyJpaRepository;
import com.example.demo.repositories.cache.MyCacheRepository;

@RestController
public class DemoController {
	
	@Autowired
	private MyJpaRepository jpaRepository;
	
	@Autowired
	private MyCacheRepository cacheRepository;

	@RequestMapping(value="/entries", method = RequestMethod.GET, produces = "application/json")
	public String saveCountry() {
		
		SimpleEntry entry = new SimpleEntry();
		entry.setName("New Entry");
		jpaRepository.save(entry);

		System.out.println("entry " + entry.getId() + " \"" + entry.getName() + "\" saved.");
		
		CacheEntry cacheEntry = new CacheEntry();
		cacheEntry.setId(String.valueOf(entry.getId()));
		cacheEntry.setName(entry.getName());
		
		cacheRepository.save(cacheEntry);
		
		System.out.println("cache entry " + cacheEntry.getId() + " \"" + cacheEntry.getName() + "\" saved.");
		
		SimpleEntry entry2 = new SimpleEntry();
		entry2.setName("New Entry");
		jpaRepository.save(entry2);
		
		jpaRepository.save(entry2);
		
		System.out.println("entry2 " + entry2.getId() + " \"" + entry2.getName() + "\" saved.");
		
		return entry.getName();
	}
}
