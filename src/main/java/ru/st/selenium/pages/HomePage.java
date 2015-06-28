package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends InternalPage {

	public HomePage(PageManager pages) {
		super(pages);
	}
	
  @FindBy(xpath = "//img[@alt='Add movie']")
  private WebElement addMovieButton;
	
 
  public AddFilmPage clickMovieButton() {
	    addMovieButton.click();
	    return pages.addFilmPage;
	  }   


  public HomePage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath("//img[@alt='Add movie']")));
    //wait.until(presenceOfElementLocated(By.cssSelector("div.content h2")));
    return this;
  }
}
