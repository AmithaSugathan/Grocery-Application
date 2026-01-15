package constants;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String VALIDCREDENTIALERROR="User is UNABLE to login with Valid Credentials";
	public static final String INVALIDCREDENTIALERROR="User is ABLE to login with InValid Credentials";
	public static final String INVALIDUSERNAMEVALIDPASSWORDERROR="User is ABLE to login with Invalid Username and ValidPassword";
	public static final String VALIDUSERNAMEINVALIDPASSWORDERROR="User is ABLE to login with Valid Username and InValidPassword";
	public static final String ADMINUNABLETOLOGOUT="ADMIN is UNABLE to LOGOUT";
	public static final String ADMINUNABLETOADDNEWUSER="ADMIN is UNABLE to ADD New User";
	public static final String ADMINUNABLETOSEARCHNEWUSER="ADMIN is UNABLE to SEARCH New User";
	public static final String ADMINUNABLETORESET="ADMIN is UNABLE to SEARCH New User";
	public static final String USERUNABLETOADDNEWS="NO New NEWS is  Added!";
	public static final String USERUNABLETOSEARCHNEWS="New NEWS Search is UNSUCCESSFULL";
	
	
	
	//Full path="C:\Users\rethe\eclipse-workspace\GroceryApplication\src\main\resources\Config.property"
	//System.getProperty("user.dir") will give till C:\Users\rethe\eclipse-workspace\GroceryApplication\

}
