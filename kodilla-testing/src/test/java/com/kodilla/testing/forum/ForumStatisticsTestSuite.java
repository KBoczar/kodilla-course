package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        forumStatistics = new ForumStatistics();
    }

    @Test
    @DisplayName("Test: Gdy liczba postów = 0")
    void testCalculateAdvStatisticsWhenNoPosts() {
        when(statisticsMock.usersNames()).thenReturn(List.of("User1", "User2"));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getUserCount());
        assertEquals(0, forumStatistics.getPostCount());
        assertEquals(5, forumStatistics.getCommentCount());
        assertEquals(0.0, forumStatistics.getAvgPostsPerUser());
        assertEquals(2.5, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0.0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Test: Gdy liczba postów = 1000")
    void testCalculateAdvStatisticsWhenManyPosts() {
        when(statisticsMock.usersNames()).thenReturn(List.of("User1", "User2"));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(1000, forumStatistics.getPostCount());
        assertEquals(500, forumStatistics.getCommentCount());
        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Test: Gdy liczba komentarzy = 0")
    void testCalculateAdvStatisticsWhenNoComments() {
        when(statisticsMock.usersNames()).thenReturn(List.of("User1", "User2"));
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Test: Gdy liczba komentarzy < liczba postów")
    void testCalculateAdvStatisticsWhenMorePostsThanComments() {
        when(statisticsMock.usersNames()).thenReturn(List.of("User1", "User2"));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Test: Gdy liczba komentarzy > liczba postów")
    void testCalculateAdvStatisticsWhenMoreCommentsThanPosts() {
        when(statisticsMock.usersNames()).thenReturn(List.of("User1", "User2"));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2.0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Test: Gdy liczba użytkowników = 0")
    void testCalculateAdvStatisticsWhenNoUsers() {
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getUserCount());
        assertEquals(0.0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0.0, forumStatistics.getAvgCommentsPerUser());
    }

    @Test
    @DisplayName("Test: Gdy liczba użytkowników = 100")
    void testCalculateAdvStatisticsWhenManyUsers() {
        List<String> users = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            users.add("User" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(100, forumStatistics.getUserCount());
        assertEquals(1.0, forumStatistics.getAvgPostsPerUser());
        assertEquals(2.0, forumStatistics.getAvgCommentsPerUser());
    }
}
