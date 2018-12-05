package com.cloud.store.dao;

import com.cloud.store.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author squirrel
 * @date 2018-12-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoTest {

    @Autowired
    PersonDao personDao;

    /**
     * 增加数据
     */
    @Test
    public void save() {
        Person person = new Person();
//        person.setId(1L);
//        person.setName("tom");
//        person.setAge(10);
        person.setId(2L);
        person.setName("jeck");
        person.setAge(20);
        Person person1 = personDao.save(person);
        System.out.println("-----------------");
        System.out.println(person1.getId() + "\t" + person1.getName() + "\t" + person1.getAge());
    }

    /**
     * 查询全部数据
     */
    @Test
    public void findAll() {
        List<Person> list = personDao.findAll();
        if (!list.isEmpty()) {
            list.forEach(person -> {
                System.out.println("-----------------");
                System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getAge());
            });
        }
    }

    /**
     * 查询个数
     */
    @Test
    public void count() {
        Long count = personDao.count();
        System.out.println(count);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void countByExample() {
        Person person = new Person();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true)
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("pageNum", "pageSize");
        Example example = Example.of(person, exampleMatcher);
        Long count = personDao.count(example);
        System.out.println(count);
    }

    @Test
    public void findAllSort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Person> list = personDao.findAll(sort);
        if (!list.isEmpty()) {
            list.forEach(person -> {
                System.out.println("-----------------");
                System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getAge());
            });
        }
    }

    @Test
    public void insertAll() {
        List<Person> list = new ArrayList<>(2);
        Person person1 = new Person();
        person1.setId(3L);
        person1.setName("tim");
        person1.setAge(22);
        list.add(person1);

        Person person2 = new Person();
        person2.setId(4L);
        person2.setName("mic");
        person2.setAge(24);
        list.add(person2);

        List<Person> resultList = personDao.saveAll(list);
        if (!resultList.isEmpty()) {
            resultList.forEach(person -> {
                System.out.println("-----------------");
                System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getAge());
            });
        }
    }
}
