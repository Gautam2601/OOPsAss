package com.example.demo;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    private int postID;
    private int userID;
    private String postBody;

    public Post(int postID, int userID, String postBody) {
        this.postID = postID;
        this.userID = userID;
        this.postBody = postBody;
    }

    public Post() {

    }

    // Getters and setters
    // Omitted for brevity
    public int getpostID() {
        return postID;
    }
    public void setpostID(int postID) {
        this.postID = postID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getPostBody() {
        return postBody;
    }
    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
