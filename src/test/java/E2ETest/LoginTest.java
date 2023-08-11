package E2ETest;

import java.io.IOException;

import org.testng.annotations.Test;

import Helper.Base;
import Utility.Utility;

public class LoginTest extends Base {
  @Test
  public void verifyUserIsLoginWithValidPassword() throws IOException, Exception {
	  
	  Utility util = new Utility();
	  util.adminLogin();
	  
  }
  public void verifyUsercanLogout() throws IOException, Exception {
	  
	  Utility util = new Utility();
	  util.adminLogout();
  }
  
  public void verifyUserIsLoginWithInvalidPassword() throws IOException, Exception{
	  Utility util = new Utility();
	  util.admininvalidlogin();
  }
}
