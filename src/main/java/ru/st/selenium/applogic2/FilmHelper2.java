package ru.st.selenium.applogic2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.AddFilmPage;
import ru.st.selenium.pages.HomePage;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    //отправляемся на домашнюю старницу с фильмами
	HomePage home = pages.internalPage.ensurePageLoaded()
			.clickHomeLink()
		    .ensurePageLoaded();
	//нажали кнопку add movie и грузим страничку 
	AddFilmPage addFilm = home.clickMovieButton().ensurePageLoaded();
			addFilm.setFilmName(film.getTitle())
			.setYear(film.getYear())
			.setAlsoKnownAs(film.getNotes())
			.clickSubmitButton();   
	
	assertEquals(film.getTitle()+" ("+film.getYear()+")"
			, pages.filmContentPage.ensurePageLoaded().getFullFilmName());    
	
  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

}
