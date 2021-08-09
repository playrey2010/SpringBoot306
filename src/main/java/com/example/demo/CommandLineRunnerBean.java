package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DirectorRepository directorRepository;

    public void run(String... args){

        User user = new User("bart", "bart@domain.com", "bart", "Bart", "Simpson",
                true);
        Role userRole = new Role("bart", "ROLE_USER");
        userRepository.save(user);
        roleRepository.save(userRole);

        User admin = new User("super", "super@domain.com", "super",
                "Super", "Hero", true);
        Role adminRole1 = new Role("super", "ROLE_ADMIN");
        Role adminRole2 = new Role("super", "ROLE_USER");
        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);

        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About stars...");
        movie.setDirector(director);

        Movie movie2 = new Movie();
        movie2.setTitle("DeathStar Ewoks");
        movie2.setYear(2011);
        movie2.setDescription("About Ewoks on the Deathstar...");
        movie2.setDirector(director);

        Set<Movie> movies = new HashSet<>();
        movies.add(movie);
        movies.add(movie2);

        director.setMovies(movies);
        directorRepository.save(director);
    }

}
