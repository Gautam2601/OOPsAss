package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDAOService implements PersonDAO {
    private int currentUserId = 0;
    private int currentpostID = 0;
    private int currentcommentID = 0;
    private final PersonRepository personRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PersonDAOService(PersonRepository personRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.personRepository = personRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

@Override
public String Signup(Person person) {
    Optional<Person> p = personRepository.findByEMail(person.getEMail());
    if (p.isEmpty()) {
        currentUserId++; // Increment the user ID
        person.setId(currentUserId);
        personRepository.save(person);
        return "Account Creation Successful";
    } else {
        return "Forbidden, Account already exists";
    }
}


    @Override
    public String Login(Person person) {
        Optional<Person> p = personRepository.findByEMail(person.getEMail());
        if (p.isEmpty()) {
            return "User does not exist";
        } else {
            if (p.get().getPassword().equals(person.getPassword())) {
                return "Login Successful";
            } else {
                return "Username/Password Incorrect";
            }
        }
    }

    @Override
    public List<Person> selectAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> LoggedInPersons() {
        return List.of();
    }

    @Override
    public List<Post> getAllPost() {
        // Not implemented for H2 database
        return postRepository.findAll();
        //return null;
    }



    @Override
    public String SelectPerson(int id) {
        Optional<Person> p = personRepository.findById(id);
        return p.map(Person::getEMail).orElse("User does not exist");
    }

    @Override
    public int deletePerson(int id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updatePerson(int id, Person person) {
        Optional<Person> p = personRepository.findById(id);
        if (p.isPresent()) {
            person.setId(id);
            personRepository.save(person);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String makeNewPost(Post post) {
        Optional<Person> optionalPerson = personRepository.findById(post.getUserID());
        if (optionalPerson.isPresent()) {
            post.setpostID(generatepostID());
            postRepository.save(post);
            return "Post created successfully";
        } else {
            return "User does not exist";
        }
    }

    public String postComment(Comment comment) {
        Optional<Post> OpPost = postRepository.findById(comment.getpostID());
        Optional<Person> OpPerson = personRepository.findById(comment.getId());
        if (OpPost.isPresent() && OpPerson.isPresent()) {
            comment.setcommentID(generatecommentID());
            commentRepository.save(comment);
            return "Comment created successfully";
        } else if (OpPost.isPresent()) {
            return "User does not exist";
        } else {
            return "Post does not exist";
        }
    }


    public String updatePost(int postID, String postBody) {
        Optional<Post> optionalPost = postRepository.findById(postID);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPostBody(postBody);
            postRepository.save(post);
            return "Post edited successfully";
        } else {
            return "Post does not exist";
        }
    }


    public String deletePost(int postID){
        Optional<Post> opPost = postRepository.findById(postID);
        if (opPost.isPresent()) {
            postRepository.delete(opPost.get());
            return "Post deleted";
        }else{
            return "Post does not exist";
        }
    }


    @Override
    public String updateComment(int commentID, String commentBody){
        Optional<Comment> optionalPost = commentRepository.findById(commentID);
        if (optionalPost.isPresent()) {
            Comment comment = optionalPost.get();
            comment.setCommentBody(commentBody);
            commentRepository.save(comment);
            return "comment edited successfully";
        } else {
            return "comment does not exist";
        }
    }

    @Override
    public String deleteComment(int commentID) {

        Optional<Comment> opPost = commentRepository.findById(commentID);
        if (opPost.isPresent()) {
            commentRepository.delete(opPost.get());
            return "Comment deleted";
        }else{
            return "Comment does not exist";
        }
    }

    // Example:
        // Post post = // Retrieve post from database
        // List<Comment> comments = // Retrieve comments from database
        // return new GetCommentClass(post, comments);
        private synchronized int generateUserId() {
            return personRepository.findAll().size() + 1;
        }


    private synchronized int generatepostID() {
        return ++currentpostID;
    }

    private synchronized int generatecommentID() {
        return ++currentcommentID;
    }

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

}







