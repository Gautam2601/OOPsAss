package com.example.demo;
import java.util.UUID;
import java.lang.Math;
import java.util.*;
import java.util.Random;
public interface PersonDAO {
    Random random = new Random();

    String Signup(Person person); //the abstract method

    String Login(Person person);
//    default String Signup(Person person){
//        return Signup(random.nextInt(), person);
//    }//the default method

    String SelectPerson(int id);

    int updatePerson(int id, Person person);

    int deletePerson(int id);

    List<Person> selectAllPersons();

    List<Person> LoggedInPersons();

    String makeNewPost(Post post);

    String postComment(Comment comment);

    List<Post> getAllPost();

    String updatePost(int postID, String postBody);

    String deletePost(int postID);

    String updateComment(int commentID, String commentBody);

    String deleteComment(int commentID);
}
