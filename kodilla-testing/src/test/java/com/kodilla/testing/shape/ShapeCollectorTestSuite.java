package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollector Test Suite")
class ShapeCollectorTestSuite {

    private ShapeCollector shapeCollector;

    @BeforeEach
    public void setup() {
        shapeCollector = new ShapeCollector();
        System.out.println("Starting test...");
    }

    @AfterEach
    public void teardown() {
        System.out.println("Test completed.");
    }

    @Nested
    @DisplayName("Tests for adding and removing figures")
    class AddRemoveTests {

        @Test
        @DisplayName("Should add a figure")
        void testAddFigure() {
            // Given
            Shape circle = new Circle(5);

            // When
            shapeCollector.addFigure(circle);

            // Then
            assertEquals(1, shapeCollector.getFiguresCount());
            assertEquals(circle, shapeCollector.getFigure(0));
        }

        @Test
        @DisplayName("Should remove a figure")
        void testRemoveFigure() {
            // Given
            Shape square = new Square(4);
            shapeCollector.addFigure(square);

            // When
            boolean result = shapeCollector.removeFigure(square);

            // Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getFiguresCount());
        }
    }

    @Nested
    @DisplayName("Tests for retrieving figures")
    class GetFigureTests {

        @Test
        @DisplayName("Should return figure from given index")
        void testGetFigure() {
            // Given
            Shape triangle = new Triangle(3, 4);
            shapeCollector.addFigure(triangle);

            // When
            Shape retrievedFigure = shapeCollector.getFigure(0);

            // Then
            assertEquals(triangle, retrievedFigure);
        }

        @Test
        @DisplayName("Should return null if index is out of bounds")
        void testGetFigureOutOfBounds() {
            // When
            Shape retrievedFigure = shapeCollector.getFigure(5);

            // Then
            assertNull(retrievedFigure);
        }
    }

    @Nested
    @DisplayName("Tests for showing all figures")
    class ShowFiguresTests {

        @Test
        @DisplayName("Should return names of all figures")
        void testShowFigures() {
            // Given
            shapeCollector.addFigure(new Circle(3));
            shapeCollector.addFigure(new Square(4));
            shapeCollector.addFigure(new Triangle(5, 6));

            // When
            String figuresList = shapeCollector.showFigures();

            // Then
            assertEquals("Circle, Square, Triangle", figuresList);
        }
    }
}
