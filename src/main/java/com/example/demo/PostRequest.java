package com.example.demo;

public class PostRequest {
    private int userID; // User ID
    private String postBody;
    private int postID; // Post ID

    // Constructors, getters, and setters
    PostRequest(int userID, String postBody, int postID) {
        this.userID = userID;
        this.postBody = postBody;
    }
    public int getId() {
        return userID;
    }
    public String getPostBody() {
        return postBody;
    }
    public int getpostID() {
        return postID;
    }
    public void setId(int userID) {
        this.userID = userID;
    }
    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
    public void setpostID(int postID) {
        this.postID = postID;
    }
    // Omitted for brevity
}
