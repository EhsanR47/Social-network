import java.util.ArrayList;
import java.util.Scanner;

public class social_main {
	static ArrayList<user> users = new ArrayList<user>();
	static String name;
	static String lastname;
	static String birthplace;
	static String password;
	static int year;
	static int conn=0;
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) 
	{
		String input = new String();
		int index;
		System.out.println("///////////////////////Initial//////////////////////////");
		users.add(new user("amin","rassekh","anzali",1369,"123"));
		users.add(new user("ehsan","rassekh","anzali",1374,"123"));
		users.add(new user("hosein","rassekh","anzali",1359,"123"));
		users.add(new user("ali","barze","rasht",1366,"123"));
		users.add(new user("amir","javan","tehran",1324,"123"));
		users.add(new user("homa","zarandi","ghazvin",1344,"123"));
		users.add(new user("david","abay","anzali",1375,"123"));
		users.add(new user("maryam","zolghadri","khomam",1384,"123"));
		users.add(new user("armin","rassekh","anzali",1392,"123"));
		users.add(new user("marry","rassekh","anzali",1366,"123"));
		
		addfriend(users.get(0), users.get(1));
		addfriend(users.get(1), users.get(0));
		
		addfriend(users.get(0), users.get(2));
		addfriend(users.get(2), users.get(0));
		
		addfriend(users.get(0), users.get(3));
		addfriend(users.get(3), users.get(0));
		
		addfriend(users.get(1), users.get(3));
		addfriend(users.get(3), users.get(1));
		
		addfriend(users.get(0), users.get(5));
		addfriend(users.get(5), users.get(0));
		
		addfriend(users.get(1), users.get(5));
		addfriend(users.get(5), users.get(1));
		
		addfriend(users.get(2), users.get(7));
		addfriend(users.get(7), users.get(2));
		
		addfriend(users.get(5), users.get(7));
		addfriend(users.get(7), users.get(5));
		
		addfriend(users.get(9), users.get(7));
		addfriend(users.get(7), users.get(9));
		
		addfriend(users.get(1), users.get(4));
		addfriend(users.get(4), users.get(1));
		
		addfriend(users.get(4), users.get(5));
		addfriend(users.get(5), users.get(4));
		
		addfriend(users.get(4), users.get(2));
		addfriend(users.get(2), users.get(4));
		
		addfriend(users.get(2), users.get(8));
		addfriend(users.get(8), users.get(2));
		
		addfriend(users.get(8), users.get(5));
		addfriend(users.get(5), users.get(8));
		
		addfriend(users.get(8), users.get(1));
		addfriend(users.get(1), users.get(8));
		
		addfriend(users.get(1), users.get(6));
		addfriend(users.get(6), users.get(1));

		showall(users,"friends");
		System.out.println("////////////////////////////////////////////////////////");
		//System.out.println(find("maede"));
		//System.out.println(samefriends(users.get(0), users.get(7),false));
		/*suggestfriend(users.get(0), users.get(1).name);
		suggestfriend(users.get(0), users.get(2).name);
		System.out.println(search(users.get(0), users.get(0), "suggestfriend"));*/
/*		String s="vhhjvhj";
		try
		{
		int num=Integer.parseInt(s.substring(0, s.indexOf("-")));
		int same=Integer.parseInt(s.substring(s.indexOf("-")+1,s.length()));
		System.out.println(num);
		System.out.println(same);}
		catch(Exception e)
		{
			System.out.println("Error");
		}*/
		
		
		while(true)
		{
			System.out.println(  "//////////////////////////////"
					         + "\r1: Creat new acount"
					         + "\r2: Log in          "
					         + "\r//////////////////////////////");
			System.out.print("Please select 1, 2 : ");
			input = in.next();
			switch (input) 
			{
			case "1" :
				System.out.print("Name: ");
				name=in.next();
				System.out.print("LastName: ");
				lastname=in.next();
				System.out.print("Birthplace: ");
				birthplace=in.next();
				System.out.print("year of Birth: ");
				year=in.nextInt();
				System.out.print("password: ");
				password=in.next();
				users.add(new user(name,lastname,birthplace,year,password));
				break;
			case "2" :
				System.out.print("Please input name: ");
				name=in.next();
				index=find(name);
				if(index==-1)
				{
					System.out.println("The user not fount");
				}
				else
				{
					System.out.print("Please input password: ");
					password=in.next();
					if(users.get(index).password.equals(password))
					{
						login(index);
					}
					else
					{
						System.out.println("Password is not true, try again ");
					}
				}
				break;
			default :
				break;
			}
			if (input.equals("exit"))
			{
				break;
			}
		}
		showall(users,"friends");
		
	}
	//////////////////////////login////////////////////////////////////
	public static void login(int index)
	{
		acceptorreject(index, users.get(index));
		//showall(users,"friendrequest");
		String input;
		int num;
		while(true)
		{
			System.out.println("///////////////////////////////////"
					       + "\r1: Show my friends"
						   + "\r2: Friend request "
						   + "\r3: Same friends   "
						   + "\r4: delete         "
						   + "\r5: Block          "
						   + "\r6: Connection     "
						   + "\rlogout            "
						   + "\r//////////////////////////////////");
			System.out.print("Please select 1, 2, ..., 6 : ");
			input = in.next();
			switch (input) 
			{
			case "1" :
				show(users.get(index), "'s friends: ", "friends");
				System.out.println();
			break;
			case "2" :
			System.out.print("Please input name: ");
			name=in.next();
			num=find(name);
				if(num==-1)
				{
					System.out.println("The user not fount");
				}
				else
				{
					if(!search(users.get(num),users.get(index),"friends") 
					&& !search(users.get(num),users.get(index),"friendrequest")
					&& !search(users.get(num),users.get(index),"block")
					&& !search(users.get(index),users.get(num),"block"))
					{
						friendrequest(users.get(num), users.get(index));
						System.out.println("Your friend request has been sent");
					}
					else
					{
						System.out.println("Is not possible");
					}
						//showall(users,"friendrequest");
					
				}
			break;
			case "3" :
				System.out.println("number-same/default : ");
				String input3=in.next();
				try
				{
					int number=Integer.parseInt(input3.substring(0, input3.indexOf("-")));
					int same=Integer.parseInt(input3.substring(input3.indexOf("-")+1,input3.length()));
					suggest(users.get(index), number, same);
				}
				catch(Exception e)
				{
					suggest(users.get(index), 1, 1);
				}
				
			break;	
			case "4" :
				System.out.print("Please input name: ");
				name=in.next();
				num=find(name);
					if(num==-1)
					{
						System.out.println("The user not fount");
					}
					else
					{
						deletefriend(users.get(index), users.get(num));
						deletefriend(users.get(num), users.get(index));
					}
			break;
			case "5" :
				System.out.print("Please input name: ");
				name=in.next();
				num=find(name);
					if(num==-1)
					{
						System.out.println("The user not fount");
					}
					else
					{
						deletefriend(users.get(index), users.get(num));
						deletefriend(users.get(num), users.get(index));
						block(users.get(index), users.get(num));
						showall(users,"block");
					}
			break;
			case "6" :
				System.out.print("Please input name to find connection: ");
				name=in.next();
				num=find(name);
				if(num==-1)
				{
					System.out.println("The user not fount");
				}
				else
				{
					if(!searchname(users.get(index), name))
					{
						conn=0;
						users.get(index).suggestfriend=null;
						connection(users.get(index), index, name);
						if(conn==0)
						{
							System.out.println("No connection between you and "+name+" exist");
						}
						else
						{
							System.out.println(conn+" connection between you and "+name+" exist");
						}
					}
					else
					{
						System.out.println(name+" is your friend");
					}
				}
			break;
			default :
			break;
			}
			if (input.equals("logout"))
			{
				break;
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////find////////////////////////////////////
	public static int find(String name)
	{
		int j=-1;
		for (int i=0;i<users.size();i++) 
		{
			if(users.get(i).name.equals(name))
			{
				j=i;
				break;
			}
		}
		return j;
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////addfriend////////////////////////////////
	public static void addfriend(user next,user friend)
	{
		if(next.friends != null)
		{
			addfriend(next.friends, friend);
		}
		else
		{
			next.friends = new user(friend.name);
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////friendrequest///////////////////////////
	public static void friendrequest(user next,user friend)
	{
		if(next.friendrequest != null)
		{
			friendrequest(next.friendrequest, friend);
		}
		else
		{
			next.friendrequest = new user(friend.name);
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////acceptorreject///////////////////////////
	public static void acceptorreject(int index,user next)
	{
		String input;
		int num;
		if(next.friendrequest != null)
		{
			num=find(next.friendrequest.name);
			System.out.println("Are you accept "+next.friendrequest.name +" friend request?(Y/N/ignore)");
			input=in.next();
			switch (input) 
			{
			case "y" :
				addfriend(users.get(index), users.get(num));
				addfriend(users.get(num), users.get(index));
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));		
			break;
			case "Y" :
				addfriend(users.get(index), users.get(num));
				addfriend(users.get(num), users.get(index));
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));
			break;
			case "N" :
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));
			break;
			case "n" :
				acceptorreject(index, next.friendrequest);
				deletefriendrequest(users.get(index), users.get(num));
			break;
			default :
				acceptorreject(index, next.friendrequest);
			break;
			}
			
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////block///////////////////////////////////
	public static void block(user next,user block)
	{
		if(next.block != null)
		{
			block(next.block, block);
		}
		else
		{
			next.block = new user(block.name);
		}
	}
	///////////////////////////////////////////////////////////////////
	
	//////////////////////////deletefriend////////////////////////////////
	public static void deletefriend(user next,user friend)
	{
		if(next.friends != null)
		{
			if(next.friends.name.equals(friend.name))
			{
				user temp=new user();
				temp=next.friends.friends;
				next.friends=temp;
			}
			else
			{
				deletefriend(next.friends,friend);
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	//////////////////////////deletefriendrequest////////////////////////////////
	public static void deletefriendrequest(user next,user friend)
	{
		if(next.friendrequest != null)
		{
			if(next.friendrequest.name.equals(friend.name))
			{
				user temp=new user();
				temp=next.friendrequest.friendrequest;
				next.friendrequest=temp;
			}
			else
			{
				deletefriendrequest(next.friendrequest,friend);
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	////////////////////////suggest///////////////////////////////
	public static void suggest(user u1, int number, int same)
	{
		user temp1=new user();
		user temp2=new user();
		u1.suggestfriend=null;
		temp1=u1;
		int k;
		int i=0;
		while(i<number)
		{
			if(temp1.friends!=null)
			{
				k=find(temp1.friends.name);
				temp2=users.get(k);
				while(i<number)
				{
					if(temp2.friends!=null)
					{
						if(!search(u1, users.get(find(temp2.friends.name)),"friends")
						&& !search(u1, users.get(find(temp2.friends.name)),"suggestfriend"))
						{
							if(samefriends(u1, users.get(find(temp2.friends.name)), false)>=same)
							{
								suggestfriend(u1, temp2.friends.name);
								temp2=temp2.friends;
								i++;
							}
							else
							{
								temp2=temp2.friends;
							}
						}
						else
						{
							temp2=temp2.friends;
						}
					}
					else
					{
						break;
					}
				}
				temp1=temp1.friends;
			}
			else
			{
				break;
			}
		}
		show(u1.suggestfriend,",", "suggestfriend");
	}
	///////////////////////////////////////////////////////////////////	
	////////////////////////suggestfriend///////////////////////////////
	public static void suggestfriend(user next,String name)
	{
		if(next.suggestfriend != null)
		{
			suggestfriend(next.suggestfriend, name);
		}
		else
		{
			next.suggestfriend = new user(name);
		}
	}
	//////////////////////////deletesuggestfriend////////////////////////////////
	public static void deletesuggestfriend(user next,user friend)
	{
		if(next.suggestfriend != null)
		{
			if(next.suggestfriend.name.equals(friend.name))
			{
				user temp=new user();
				temp=next.suggestfriend.suggestfriend;
				next.suggestfriend=temp;
			}
			else
			{
				deletesuggestfriend(next.suggestfriend,friend);
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	////////////////////////connection/////////////////////////////////
	public static void connection(user u1,int index,String name)
	{
		
		if(u1.friends!=null)
		{
			if(!search(users.get(index), u1.friends, "suggestfriend"))
			{
				suggestfriend(users.get(index), u1.friends.name);
				if(!u1.friends.name.equals(name))
				{
					connection(users.get(find(u1.friends.name)), index, name);
					if(!search(users.get(index), users.get(find(name)), "suggestfriend"))
					{
						deletesuggestfriend(users.get(index), users.get(find(u1.friends.name)));
						connection(u1.friends, index, name);
					}
					else
					{
						show(users.get(index),",", "suggestfriend");
						System.out.print("("+findlength(users.get(index))+")");
						conn++;
						System.out.println("");
						deletesuggestfriend(users.get(index),users.get(find(name)));
						deletesuggestfriend(users.get(index), users.get(find(u1.friends.name)));
						connection(u1.friends, index, name);
					}
				}
			}
			else
			{
				connection(u1.friends, index, name);
			}
		}
		
	}
	///////////////////////////////////////////////////////////////////
	///////////////////////////findlength//////////////////////////////
	public static int findlength(user u1)
	{
		int count=0;
		user temp=new user();
		temp=u1;
		while(temp.suggestfriend!=null)
		{
			count++;
			temp=temp.suggestfriend;
		}

		return count;
	}
	///////////////////////////////////////////////////////////////////
	////////////////////////samefriends///////////////////////////////
	//for test "not used"
	public static int samefriends(user u1, user u2, boolean mode)
	{
		user temp=new user();
		temp=u2;
		int i=0;
		boolean flag=false;
		while(temp.friends!=null)
		{
			if(searchname(u1, temp.friends.name))
			{
				i++;
				if(mode)
				{
					System.out.println(temp.friends.name);
				}
				flag=true;
			}
			temp=temp.friends;
		}
		if(!flag)
		{
			if(mode)
			{
				System.out.println("Not Found");
			}
		}
		return i;
	}
	///////////////////////////////////////////////////////////////////	
	////////////////////////////searchname/////////////////////////////
	public static boolean searchname(user u1, String name)
	{
		user temp=new user();
		temp=u1;
		boolean flag=false;
		while(temp.friends!=null)
		{
			if(temp.friends.name.equals(name))
			{
				flag=true;
				break;
			}
				temp=temp.friends;
				
		}
		return flag;
	}
	///////////////////////////////////////////////////////////////////	
	//////////////////////////////search//////////////////////////////
	public static boolean search(user u1, user u2, String s)
	{
		user temp=new user();
		temp=u1;
		boolean flag=false;
		while(temp!=null)
		{
			if(temp.name.equals(u2.name))
			{
				flag=true;
				break;
			}
			switch (s)
			{
				case "friends" :	
					temp=temp.friends;
					break;
				case "friendrequest" :
					temp=temp.friendrequest;
					break;
				case "block" :
					temp=temp.block;
					break;
				case "suggestfriend" :
					temp=temp.suggestfriend;
				break;
				default :	
			}
				
		}
		return flag;
	}
	///////////////////////////////////////////////////////////////////
	public static void show(user person, String n,String s)
	{
		if(person != null)
		{
			System.out.print(person.name+n);
			switch (s)
			{
				case "friends" :	
					show(person.friends,", ",s);
				break;
				case "friendrequest" :
					show(person.friendrequest,", ",s);
				break;
				case "block" :
					show(person.block,", ",s);
				break;
				case "suggestfriend" :
					show(person.suggestfriend,", ",s);
				break;
				default :
				break;
			}
		}
		
	}
	public static void showall(ArrayList<user> list, String s)
	{
		
		for (user user : list) 
		{
			show(user," : ",s);
			System.out.println();
		}
	}

}
