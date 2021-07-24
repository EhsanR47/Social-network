public class user 
{
	String name;
	String lastname;
	String Birthplace;
	String password;
	int year;
	user friends;
	user block;
	user friendrequest;
	user suggestfriend;
	public user()
	{
		name = "";
		friends = null;
		block = null;
		friendrequest=null;
		suggestfriend=null;
	}
	public user(String name)
	{
		this.name = name;
		friends = null;
		block = null;
		friendrequest=null;
		suggestfriend=null;
	}
	public user(String name,String lastname,String Birthplace,int year,String password)
	{
		this.name = name;
		this.lastname = lastname;
		this.Birthplace=Birthplace;
		this.year  = year;
		this.password = password;
		friends = null;
		block = null;
		friendrequest=null;
		suggestfriend=null;
	}
	

}
