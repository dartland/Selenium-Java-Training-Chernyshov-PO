package ru.st.selenium.applogic2;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.AddFilmPage;
import ru.st.selenium.pages.FilmContentPage;
import ru.st.selenium.pages.HomePage;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    //������������ �� �������� �������� � ��������
	HomePage home = pages.internalPage.ensurePageLoaded()
			.clickHomeLink()
		    .ensurePageLoaded();
	//������ ������ add movie � ������ ��������� 
	AddFilmPage addFilm = home.clickMovieButton().ensurePageLoaded();
			addFilm.setFilmName(film.getTitle())
			.setYear(film.getYear())
			.setAlsoKnownAs(film.getNotes())
			.clickSubmitButton();   
  }
  
  @Override
  public boolean isFullFilmNameEquals(Film film) {
	  
	String FilmName = film.getTitle()+" ("+film.getYear()+")";   
    return pages.filmContentPage.ensurePageLoaded().getFullFilmName().equals(FilmName);
    
  }
  
  @Override
  public boolean isInputErrorYear() {
 
    return pages.addFilmPage.ensurePageLoaded().DisplaedLablelErrorYear();
    
  }
  
  @Override
  public boolean isInputErrorName() {
 
    return pages.addFilmPage.ensurePageLoaded().DisplaedLablelErrorName();
    
  }
  
  public int getSizeOfFilmList() {

	  
	  return pages.homePage.getSize(); 
  }
  
 
  @Override
  public void delete(Film film) {
	//������������ �� �������� �������� � ��������
		HomePage home = pages.internalPage.ensurePageLoaded()
				.clickHomeLink()
			    .ensurePageLoaded();
		FilmContentPage filmContent = home.getFilmContent().ensurePageLoaded();
		filmContent.clickRemoveButton().ensurePageLoaded();
  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

}
