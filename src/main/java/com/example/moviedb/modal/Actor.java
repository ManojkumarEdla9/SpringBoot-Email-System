package com.example.moviedb.modal;

public class Actor {
	private int id;
	private String name;
	private String movies;
	public Actor()
	{
		
	}
	
	public Actor(int id, String name, String movies) {
		this.id = id;
		this.name = name;
		this.movies = movies;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	
	public String getmovies()
	{
		return movies;
	}
	public void setmovies(String movies)
	{
		this.movies=movies;
	}
	
	public String toString()
	{
		return "Actor{"+"id="+id+",name"+name+'\''+",movies='"+movies+'\''+'}';
	}
}
