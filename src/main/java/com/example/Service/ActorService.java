package com.example.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.moviedb.dao.ActorDAO;
import com.example.moviedb.modal.Actor;

public class ActorService {
    private ActorDAO actorDAO;

    public ActorService() {
        this.actorDAO = new ActorDAO();
    }

    public List<Actor> getAllActors() throws SQLException {
        return actorDAO.getAllActors();
    }

    public Actor getActorById(int id) throws SQLException {
        return actorDAO.getActorById(id); // Correct method call
    }

    public void addActor(Actor actor) throws SQLException {
        actorDAO.addActor(actor);
    }

    public void updateActor(Actor actor) throws SQLException {
        actorDAO.updateActor(actor);
    }

    public void deleteActor(int id) throws SQLException {
        actorDAO.deleteActor(id);
    }

    public Actor getActor(String actorName) throws SQLException {
        return actorDAO.getActor(actorName);
    }
}
