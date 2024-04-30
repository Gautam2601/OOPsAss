package com.example.demo;

import java.util.UUID;
import java.lang.Math;
import java.util.*;
import java.util.Random;

public interface PersonDAO {
    Random random = new Random();
    String Signup(int id, Person person); //the abstract method
    String Login(Person person);
    default String Signup(Person person){
        return Signup(random.nextInt(), person);
    }//the default method

    String SelectPerson(int id);
    int updatePerson(int id, Person person);
    int deletePerson(int id);
    List<Person> selectAllPersons();

    String makeNewPost(Post post);
       List<Post> getAllPost();
}
