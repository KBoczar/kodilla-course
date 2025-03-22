package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStreamMain {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String allTitles = movieStore.getMovies().values().stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.joining("!"));

        System.out.println(allTitles);
    }
}
