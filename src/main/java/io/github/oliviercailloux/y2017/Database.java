package io.github.oliviercailloux.y2017;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Database {
	// Database is the class of all the problems

	private Multimap<String,Problem> database= ArrayListMultimap.create();
	private List<Problem > problem = new ArrayList<Problem>();;
	
	 private Database() {}
	// There is one database that contains a List of Problems, so we could access to this list using the following method 
	  public   Multimap<String,Problem> getDatabases() {
	        return database;
	    }
	// To access to a problem in the database we should use the following method  
	    public List<Problem > getproblems() {
	        return problem;
	    }
	    public void addProblem(Problem pb) {
	    	database.put(pb.getId(),pb);
	    }
}
