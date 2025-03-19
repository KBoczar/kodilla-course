package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "JohnDoe", 'M', LocalDate.of(1998, 5, 15), 25));
        userList.add(new ForumUser(2, "JaneDoe", 'F', LocalDate.of(2000, 8, 20), 15));
        userList.add(new ForumUser(3, "MikeSmith", 'M', LocalDate.of(1995, 2, 10), 0));
        userList.add(new ForumUser(4, "AnnaWhite", 'F', LocalDate.of(1997, 7, 5), 8));
        userList.add(new ForumUser(5, "TomBrown", 'M', LocalDate.of(2003, 12, 1), 10));
        userList.add(new ForumUser(6, "JamesBlack", 'M', LocalDate.of(1990, 4, 22), 50));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
