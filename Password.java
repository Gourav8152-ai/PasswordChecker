package Single;
import java.util.*;

public class Password {
	HashMap < String, String > userDb = new HashMap < > ();
	Scanner sc = new Scanner(System.in);
	public void setAccount(String username,  String password) {
		userDb.put(username,password);
		System.out.println("Account Created");
		reoption(username,password);
	}
	public void reoption(String username,String password) {
		System.out.println("Enter 1 for resetPassword");
		System.out.println("Enter 2 for Exit");
		System.out.println("Enter 3 for verifyPassword");
		int temp = sc.nextInt();
		switch(temp) {
		case 1:
			resetPassword(username,password);
			break;
		case 2:
			return;
		case 3:
			System.out.println("You have been logged out !!! ");
			System.out.println("Enter a username : ");
			String user = sc.next();
			System.out.println("Enter a password : ");
			String pass = sc.next();
			verifyPassword(user,pass);
			break;
		default:
			System.out.println("Choosed a wrong option !!!");
			break;
		}
	}
	public void resetPassword(String username, String password) {
		System.out.println("Enter current Password");
		String currentPassword = sc.next();
		if(currentPassword.equals(userDb.get(username))) {
			System.out.println("Enter New Password");
			String newPassword = sc.next();
			userDb.put(username,newPassword);
			System.out.println("New Password Set");
			reoption(username,password);
		}else {
			System.out.println("Wrong currentPassword");
			reoption(username,password);
		}
	}
	public void verifyPassword(String username, String password) {
		if(userDb.containsValue(password) && userDb.containsKey(username)) {
			if(userDb.get(username) == password) {
				System.out.println("Successfully Loginned");
			}
			reoption(username,password);
			
		}else {
			System.out.println("Not Login !!! ");
			reoption(username,password);
		}
	}
	public void accountExist(String username, String password) {
		if(userDb.containsKey(username)) {
			verifyPassword(username,password);
		}else {
			setAccount(username,password);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Password pass = new Password();
		System.out.println("Enter a username : ");
		String username = sc.next();
		System.out.println("Enter a password : ");
		String password = sc.next();
		if(username == null && password == null) {
			System.out.println("Enter the username and password");
		}else {
			pass.accountExist(username, password);
		}
		sc.close();
	}
}
