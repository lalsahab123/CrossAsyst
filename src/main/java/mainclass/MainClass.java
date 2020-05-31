package mainclass;

import org.testng.annotations.Test;

import commonutilities.AppDriver;
import screens.Dashboard;

public class MainClass extends AppDriver{
	Dashboard dashboard;
	public MainClass() {
		super();
		dashboard=new Dashboard();
	}

	@Test(enabled=false)
	public void createRegistration(){
		dashboard.createAccount();
	}
	@Test
	public void productCheckOut() throws Exception{
		dashboard.loginToApplication();
		dashboard.checkOutProcess();
		dashboard.checkHistory();
	}
	


}
