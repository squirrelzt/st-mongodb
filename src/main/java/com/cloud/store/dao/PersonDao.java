package com.cloud.store.dao;

import com.cloud.store.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;


// Person是仓库中保存的bean,Long是Person的唯一标识
public interface PersonDao extends MongoRepository<Person, Long> {
}
