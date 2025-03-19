package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private BookLibrary bookLibrary;
    private LibraryUser libraryUser;

    @BeforeEach
    void setUp() {
        bookLibrary = new BookLibrary(libraryDatabaseMock);
        libraryUser = new LibraryUser("John", "Doe", "12345678901");
    }

    @Test
    @DisplayName("Test: Lista książek pasujących do warunku")
    void testListBooksWithConditionReturnList() {
        // Given
        List<Book> resultListOfBooks = List.of(
                new Book("Secrets of Alamo", "John Smith", 2008),
                new Book("Secretaries and Directors", "Dilbert Michigan", 2012),
                new Book("Secret life of programmers", "Steve Wolkowitz", 2016),
                new Book("Secrets of Java", "Ian Tenewitch", 2010)
        );
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    @DisplayName("Test: Gdy liczba książek > 20, metoda powinna zwrócić pustą listę")
    void testListBooksWithConditionMoreThan20() {
        // Given
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Any title");

        // Then
        assertEquals(0, theListOfBooks.size());
    }

    @Test
    @DisplayName("Test: Gdy szukany tytuł ma mniej niż 3 znaki, powinna być pusta lista")
    void testListBooksWithConditionFragmentShorterThan3() {
        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    @DisplayName("Test: Użytkownik nie ma żadnych wypożyczonych książek")
    void testListBooksInHandsOfWhenNoBooksBorrowed() {
        // Given
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(new ArrayList<>());

        // When
        List<Book> booksInHands = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        assertEquals(0, booksInHands.size());
    }

    @Test
    @DisplayName("Test: Użytkownik ma wypożyczoną jedną książkę")
    void testListBooksInHandsOfWhenOneBookBorrowed() {
        // Given
        List<Book> borrowedBooks = List.of(new Book("Effective Java", "Joshua Bloch", 2018));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(borrowedBooks);

        // When
        List<Book> booksInHands = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        assertEquals(1, booksInHands.size());
        assertEquals("Effective Java", booksInHands.get(0).getTitle());
    }

    @Test
    @DisplayName("Test: Użytkownik ma wypożyczonych 5 książek")
    void testListBooksInHandsOfWhenFiveBooksBorrowed() {
        // Given
        List<Book> borrowedBooks = List.of(
                new Book("Clean Code", "Robert C. Martin", 2008),
                new Book("The Pragmatic Programmer", "Andrew Hunt", 1999),
                new Book("Refactoring", "Martin Fowler", 2018),
                new Book("Design Patterns", "Erich Gamma", 1994),
                new Book("Test Driven Development", "Kent Beck", 2002)
        );
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(borrowedBooks);

        // When
        List<Book> booksInHands = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        assertEquals(5, booksInHands.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            resultList.add(new Book("Title " + n, "Author " + n, 1970 + n));
        }
        return resultList;
    }
}
