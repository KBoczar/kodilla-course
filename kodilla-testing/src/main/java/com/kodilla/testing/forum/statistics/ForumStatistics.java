package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int userCount;
    private int postCount;
    private int commentCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        userCount = statistics.usersNames().size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();

        avgPostsPerUser = (userCount > 0) ? (double) postCount / userCount : 0;
        avgCommentsPerUser = (userCount > 0) ? (double) commentCount / userCount : 0;
        avgCommentsPerPost = (postCount > 0) ? (double) commentCount / postCount : 0;
    }

    public void showStatistics() {
        System.out.println("Users: " + userCount);
        System.out.println("Posts: " + postCount);
        System.out.println("Comments: " + commentCount);
        System.out.println("Average posts per user: " + avgPostsPerUser);
        System.out.println("Average comments per user: " + avgCommentsPerUser);
        System.out.println("Average comments per post: " + avgCommentsPerPost);
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
