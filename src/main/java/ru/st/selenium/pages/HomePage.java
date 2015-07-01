package ru.st.selenium.pages;

import static org.junit.Assert.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.st.selenium.model.Film;


public class HomePage extends InternalPage {

	public HomePage(PageManager pages) {
		super(pages);
	}
	
  @FindBy(xpath = "//img[@alt='Add movie']")
  private WebElement addMovieButton;
  
  @FindBy(id = "results")
  private WebElement filmContainer; 
  
  @FindBy(id = "q")
  private WebElement searchField;  
  
  @FindBy(css = "div.content")
  private WebElement noMoviesWhereFound;  
  
  
//  @FindBy(tagName = "a")
//  private WebElement filmList;
  
  public List<Film> ensureFilmsLoaded(String title) {
      
	  //Film film = new Film();
  /*  WebElement FilmContainerOld = driver.findElement(By.id("results"));
      List<WebElement> FilmsOld = FilmContainerOld.findElements(By.tagName("a"));
      searchField.clear(); searchField.sendKeys(title+Keys.RETURN);
      for (int count = 0;; count ++) {
    	    if (count >= 30)
    	        throw new TimeoutException();
    	    try {
    	    	driver.manage().timeouts(). implicitlyWait(0, TimeUnit.SECONDS); 
    	    	FilmsOld.get(0).getText();
    	        
    	    } catch (StaleElementReferenceException e) 
    	    	{  break; }
    	    Thread.sleep(1000);
      }
           
      driver.manage().timeouts(). implicitlyWait(30, TimeUnit.SECONDS); 
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  //этот элемент тоже исчезает и появляется, ждем его появления
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
	  WebElement FilmContainerNew = driver.findElement(By.id("results"));
      for (int count = 0;; count ++) {
  	    if (count >= 30) { throw new TimeoutException();}
  	    List<WebElement> films = FilmContainerNew.findElements(By.tagName("a")); 
  	    if (films.size()>0) {break;}
  	    //Thread.sleep(1000);
  	  }
      
  		
  	  */
	  System.out.println("***********************************");
	  searchField.clear(); searchField.sendKeys(title+Keys.RETURN);
	  String NameFilm;
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("results")));
	  WebElement FilmContainerNew = driver.findElement(By.id("results"));
      List<WebElement> films = FilmContainerNew.findElements(By.tagName("a")); 
      for (int i = 0; i < films.size(); i++) {
 
    	  
    	WebElement film_cell = films.get(i);
    	//NameFilm = film_cell.findElement(By.className("title")).getText();
    	System.out.println("Имя фильма ="+film_cell.getText());		
  		 //film.setNotes(films.get(i).getAttribute(arg0));
      }
      
   return null;
  }

  
  
  public String getEmptySearchText() {
	 
	 //возможно стоит добавить ожидание видимости 
	 return noMoviesWhereFound.getText(); 
	  
  }
  
  
  public HomePage setSearchFieldAndPressEnterButton(String searchString) {
	    searchField.clear();
	    searchField.sendKeys(searchString+Keys.RETURN);
	    
	    return pages.homePage;
	  } 
  
  public HomePage setSearchFieldAndPressEnterButton2(String searchString) {
	    searchField.clear();
	    searchField.sendKeys("searchString"+Keys.RETURN);
	    
	    return pages.homePage;
	  } 
 
  public AddFilmPage clickMovieButton() {
	    addMovieButton.click();
	    return pages.addFilmPage;
	  }   
  
  public FilmContentPage getFilmContent() {
	    
	  List<WebElement> Films = filmContainer.findElements(By.tagName("a"));
	  int FilmsSize = Films.size();
	  if(FilmsSize>0) {
		Films.get(2).click();
		}	  
	 return pages.filmContentPage;
	 } 

  public int getSize() {
	 List<WebElement> Films = filmContainer.findElements(By.tagName("a"));
	 return Films.size();
  }
  
  
  public HomePage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath("//img[@alt='Add movie']")));
    //wait.until(presenceOfElementLocated(By.cssSelector("div.content h2")));
    return this;
  }




}
