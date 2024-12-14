package com.example.main;

import java.sql.SQLException;
import java.util.List;

import com.example.Service.ActorService;
import com.example.moviedb.modal.Actor;

//@SpringBootApplication
public class SpringBootMovieApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootMovieApplication.class, args);
		ActorService actorService=new ActorService();
		try {
			Actor actor1=new Actor(0,"Robert Downey Jr,","Iron Man,Sherlock Holmes");
			actorService.addActor(actor1);
			List<Actor>actors =actorService.getAllActors();
			System.out.println("All Actors: ");
			actors.forEach(System.out::println);
			
			Actor actorToUpdate=actorService.getActorById(actor1.getId());
			if(actorToUpdate!=null)
			{
				actorToUpdate.setmovies("Iron Man,Sherlock Holmes,Avengers");
				actorService.updateActor(actorToUpdate);
			}
			Actor actorById=actorService.getActorById(actor1.getId());
			System.out.println("\nActor by Name:");
			System.out.println(actorById);
			
			Actor actorByName=actorService.getActor("Robert Downey Jr.");
			System.out.println("\nAll Actors after deletion: ");
			actors.forEach(System.out::println);
			
			actorService.deleteActor(actor1.getId());
			
			actors=actorService.getAllActors();
			System.out.println("\n All Actors after deletion: ");
			actors.forEach(System.out::println);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
