package com.example.demo;

public class CommRequest {
    private String commentBody;
    private int postID;
    private int userID;
    private int commentID;

    CommRequest(String commentBody, int postID, int userID, int commentID) {
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = userID;
        this.commentID = commentID;
    }
    public String getCommentBody() {
        return commentBody;
    }
    public int getpostID() {
        return postID;
    }
    public int getId() {
        return userID;
    }
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    public void setpostID(int postID) {
        this.postID = postID;
    }
    public void setId(int id) {
        this.userID = id;
    }
    public int getcommentID() {
        return commentID;
    }
    public void setcommentID(int commentID) {
        this.commentID = commentID;
    }

}
