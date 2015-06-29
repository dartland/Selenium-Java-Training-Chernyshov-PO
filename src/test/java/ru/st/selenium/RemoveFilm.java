package ru.st.selenium;

import org.testng.annotations.Test;

import ru.st.selenium.model.Film;

public class RemoveFilm extends ru.st.selenium.pages.TestBase {

 
  @Test
  public void RemoveFilm() throws Exception {
	
	Film film = new Film();
	app.getFilmHelper().delete(film);
	//assertTrue(app.getFilmHelper().isFilmDelete());
	Thread.sleep(6000);
	
  }  
 
  
  

}
