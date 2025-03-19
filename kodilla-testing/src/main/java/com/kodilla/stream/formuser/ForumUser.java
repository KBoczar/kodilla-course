package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final char gender;
    private final LocalDate birthDate;
    private final int postCount;

    public ForumUser(int userId, String username, char gender, LocalDate birthDate, int postCount) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postCount = postCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", postCount=" + postCount +
                '}';
    }
}
