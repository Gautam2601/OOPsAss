package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    //PersonDAOService personDAOService = new PersonDAOService();
    private final PersonDAO personDAO; //instance of personDAO
    private final PersonRepository personRepository;

    @Autowired
    PersonService(PersonDAO personDAO, PersonRepository personRepository) {
        this.personDAO = personDAO;
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personDAO.selectAllPersons();
    }
    public List<Post> getAllPosts(){return personDAO.getAllPost();}
    public List<Person> LoggedInPersons(){
        return personDAO.LoggedInPersons();
    }

    public String addPerson(@Qualifier("findPerson") Person person){
        return personDAO.Signup(person);
    }

    // Inside PersonService class

    public String LoginPerson(@Qualifier("findPerson") Person person){
        return personDAO.Login(person);
    }

    public void deletePerson(@Qualifier("findPerson") Person person){
        personDAO.deletePerson(person.getId());
    }

    public int updatePerson(int id, @Qualifier("findPerson") Person person){
        return personDAO.updatePerson(id, person);
    }

    public int deletePerson(int id){
        return personDAO.deletePerson(id);
    }

    public String getPersonById(int id){
        return personDAO.SelectPerson(id);
    }

    public String createPost(PostRequest postRequest) {
        // Create a Post object from the request
        //Optional<Person> optionalPerson = personRepository.findById(post.getUserID());
        Post post = new Post(postRequest.getpostID(), postRequest.getId(), postRequest.getPostBody());

        // Call the DAO method to create the post
        return personDAO.makeNewPost(post);
    }

    public String editPost(Post post) {
        return personDAO.updatePost(post.getpostID(), post.getPostBody());
    }

    public String editComment(Comment comment){
        return personDAO.updateComment(comment.getcommentID(), comment.getCommentBody());
    }

    public String deletePost(int postID){
        return personDAO.deletePost(postID);
    }

    public String postComment(CommRequest commRequest){
        Comment comment = new Comment(commRequest.getCommentBody(), commRequest.getpostID(), commRequest.getId(), commRequest.getcommentID());
        return personDAO.postComment(comment);
    }


    public String deleteComment(int commentID) {
        return personDAO.deleteComment(commentID);
    }
}
