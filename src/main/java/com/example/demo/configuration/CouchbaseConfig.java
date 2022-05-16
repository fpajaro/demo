package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.example.demo.repositories.cache"})
@EnableCaching
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
	
	@Value("${couchbase.cluster.ip}")
	private String ip;
	
	@Value("${couchbase.cluster.bucket}")
	private String bucketName;
	
	@Value("${couchbase.cluster.password}")
	private String password;
	
	@Value("${couchbase.cluster.username}")
	private String userName;
     
    @Override
    public String getConnectionString() {
        return ip;
    }
 
    @Override
    public String getBucketName() {
        return bucketName;
    }
 
    @Override
    public String getPassword() {
        return password;
    }

	@Override
	public String getUserName() {
		return userName;
	}
}
