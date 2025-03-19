package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Hello, world!", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Hello, world!", String::toUpperCase);
        poemBeautifier.beautify("Hello, world!", text -> "*** " + text + " ***");
        poemBeautifier.beautify("Hello, world!", text -> text.replace(" ", "_"));
        poemBeautifier.beautify("Hello, world!", text -> new StringBuilder(text).reverse().toString());
    }
}
