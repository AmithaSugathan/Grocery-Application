package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker faker=new Faker();//Predefined Faker class. Create an obj
	public String getRandomUserName()
	{
		return faker.name().username();//Random user names are inside name()
	}
	public String getRandonPassword()
	{
	return faker.internet().password();//Random passwords are inside internet()
	}
//Just for interviews
	public String getRandomFullUserName()
	{
	 return faker.name().fullName();
	}
	public String getRandomEmailId()
	{
	 return faker.internet().emailAddress();
	}

}
