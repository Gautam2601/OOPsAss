package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")

public class Comment{
    @Id
    String commentBody;
    int postID;
    int userID;
    int commentID;

    Comment(String commentBody, int postID, int id, int commentID){
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = id;
        this.commentID = commentID;
    }
    public Comment(){}

    public String getCommentBody() {
        return commentBody;
    }
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    public int getpostID() {
        return postID;
    }
    public void setpostID(int postID) {
        this.postID = postID;
    }
    public int getId() {
        return userID;
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
