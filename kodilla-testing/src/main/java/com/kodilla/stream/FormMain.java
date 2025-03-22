package com.kodilla.stream;

import com.kodilla.stream.immutable.ForumUser;

public class FormMain {
    public static void main(String[] args) {
        ForumUser user = new ForumUser("john_doe", "John Doe");

        System.out.println("Username: " + user.getUsername());
        System.out.println("Real Name: " + user.getRealName());
    }
}
