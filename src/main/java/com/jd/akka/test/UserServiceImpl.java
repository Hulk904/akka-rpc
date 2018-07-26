package com.jd.akka.test;

/**
 * Created by yangyuan on 7/26/18.
 */
public class UserServiceImpl implements UserService{
    public Person getPersonById(Integer id) {
        Person person = new Person();
        person.setName("yy");
        person.setAge(20);
        return person;
    }
}
