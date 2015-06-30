package ru.st.selenium.pages;

import static org.junit.Assert.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
  
  public String getEmptySearchText() {
	 
	 //возможно стоит добавить ожидание видимости 
	 return noMoviesWhereFound.getText(); 
	  
  }
  
  
  
  public HomePage setSearchFieldAndPressEnterButton(String searchString) {
	    searchField.clear();
	    searchField.sendKeys("searchString"+Keys.RETURN);
	    	    
	    
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


  public HomePage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath("//img[@alt='Add movie']")));
    //wait.until(presenceOfElementLocated(By.cssSelector("div.content h2")));
    return this;
  }

  public int getSize() {
	 List<WebElement> Films = filmContainer.findElements(By.tagName("a"));
	 return Films.size();
  }
  
}
