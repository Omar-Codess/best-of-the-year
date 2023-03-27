package org.lessons.java.bestoftheyear.controller;

import org.lessons.java.bestoftheyear.model.Movie;
import org.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/")
public class BestOfTheYearController {

    @GetMapping
    public String home (Model model){
        String name = "Omar Taki";
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> list = getBestMovies();
        String titles = "";
        for (Movie m : list){
            titles += m.getTitle() + ", ";
        }
        titles = titles.substring(0, titles.length() -2);
        model.addAttribute("movies", titles);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> list = getBestSongs();
        String titles = "";
        for (Song s : list){
            titles += s.getTitle() + ", ";
        }
        titles = titles.substring(0, titles.length() -2);
        model.addAttribute("songs", titles);
        return "songs";
    }


    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Il Padrino", 1));
        movies.add(new Movie("Il Padrino II", 2));
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Thriller", 3));
        songs.add(new Song("Beat it", 4));
        return songs;
    }
}
