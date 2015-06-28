package ru.st.selenium;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class LoginTest extends ru.st.selenium.pages.TestBase {

  @BeforeMethod
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();
  }
  
  @Test
  public void testLoginOK() throws Exception {
    User user = new User().setLogin("admin").setPassword("admin");
    app.getUserHelper().loginAs(user);
    assertTrue(app.getUserHelper().isLoggedInAs(user));
    Thread.sleep(6000);
  }

/*  @Test
  public void testLoginFailed() throws Exception {
    User user = new User().setLogin("admin").setPassword("wrong");
    app.getUserHelper().loginAs(user);
    // assertFalse(app.getUserHelper().isLoggedIn());
    assertTrue(app.getUserHelper().isNotLoggedIn());
  }*/
  
  @Test
  public void addNewFilmTestPositive() throws Exception {
	    
    app.getNavigationHelper().gotoHomePage();
    
    Film film = new Film().setTitle("Selenium 2.0 + Java").setYear("2013").setNotes("WebDriver"); 
    //app.getFilmHelper().create(film);
    // assertFalse(app.getUserHelper().isLoggedIn());
    //assertTrue(app.getUserHelper().isNotLoggedIn());
  }
    

}
