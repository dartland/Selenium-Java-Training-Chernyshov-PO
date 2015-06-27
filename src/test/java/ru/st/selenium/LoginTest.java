package ru.st.selenium;

import org.testng.annotations.*;

import static org.junit.Assert.*;
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
	  
    //User user = new User().setLogin("admin").setPassword("wrong");
    app.getNavigationHelper().gotoHomePage();
    
    Film film = new Film().setTitle("Selenium 2.0 + Java").setYear("2013").setNotes("WebDriver"); 
    app.getFilmHelper().create(film);
    // assertFalse(app.getUserHelper().isLoggedIn());
    //assertTrue(app.getUserHelper().isNotLoggedIn());
  }
    

}
