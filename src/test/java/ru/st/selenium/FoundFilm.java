package ru.st.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class FoundFilm extends ru.st.selenium.pages.TestBase {


 
  @Test
  public void FoundFilm() throws Exception {
	 
	List<Film> FilmList;
	
	
	FilmList = app.getFilmHelper().search("Best");
	//assertTrue(app.getFilmHelper().isEmptySearchResult("No movies where found."));
	
	Thread.sleep(6000);
	
  }  
 
  
  

}
