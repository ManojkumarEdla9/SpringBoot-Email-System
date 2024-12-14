package com.example.moviedb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.moviedb.modal.Actor;
import com.example.moviedb.util.DatabaseConnection;

public class ActorDAO {
    public List<Actor> getAllActors() throws SQLException {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actors";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Actor actor = new Actor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("movies"));
                actors.add(actor);
            }
        }
        return actors;
    }

    public Actor getActorById(int id) throws SQLException { // Correct method signature and parameter
        Actor actor = null;
        String query = "SELECT * FROM actors WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id); // Corrected parameter setting
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    actor = new Actor(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("movies")
                    );
                }
            }
        }
        return actor;
    }

    public void addActor(Actor actor) throws SQLException {
        String query = "INSERT INTO actors (name, movies) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, actor.getname());
            preparedStatement.setString(2, actor.getmovies());
            preparedStatement.executeUpdate();
        }
    }

    public void updateActor(Actor actor) throws SQLException {
        String query = "UPDATE actors SET name = ?, movies = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, actor.getname());
            preparedStatement.setString(2, actor.getmovies());
            preparedStatement.setInt(3, actor.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteActor(int id) throws SQLException {
        String query = "DELETE FROM actors WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public Actor getActor(String id) throws SQLException {
        Actor actor = null;
        String query = "SELECT * FROM actors WHERE name = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    actor = new Actor(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("movies")
                    );
                }
            }
        }
        return actor;
    }
}
