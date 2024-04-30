package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "/Signup")
    public String createPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PostMapping(path = "/Login")
    public String login(@RequestBody Person person) {
        return personService.LoginPerson(person);
    }

    @GetMapping()
    public List<Person> getActivePersons() {
        return personService.LoggedInPersons();
    }

    @GetMapping(path = "/AllUsers")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/user")
    public String getPersonById(@RequestParam("userID") int id) {
        return personService.getPersonById(id);
    }


    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") int id) {
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") int id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest) {
        String result = personService.createPost(postRequest);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/post")
    public ResponseEntity<String> editPost(@RequestBody Post post) {
        String result = personService.editPost(post);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/comment")
    public ResponseEntity<String> editComment(@RequestBody Comment comment) {
        String result = personService.editComment(comment);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/post")
    public String DeletePost(@RequestParam("postID") int postID) {
        return personService.deletePost(postID);
    }

    @DeleteMapping("/comment")
    public String DeleteComment(@RequestParam("commentID") int commentID) {
        return personService.deleteComment(commentID);
    }

    @PostMapping(path = "/comment")
    public String postComment(@RequestBody CommRequest commRequest) {
        return personService.postComment(commRequest);
    }




}