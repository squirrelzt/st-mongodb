package com.cloud.store.dao.mongodbtemplate;

import com.cloud.store.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTemplateTest {

    @Autowired
    MongoTemplate mongodbTemplate;

    @Test
    public void query() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        criteria.andOperator(Criteria.where("name").is("jane"));
        List<Person> list = mongodbTemplate.find(query, Person.class);
        if (!list.isEmpty()) {
            list.forEach(person -> {
                System.out.println("-----------------");
                System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getAge());
            });
        }
    }
}
