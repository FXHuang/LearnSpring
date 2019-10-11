package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.*;

// 请求进来之后先由这个类拦截，然后到不同的控制类
public class CatchHelper {
	
	private UserController userController = new UserController();
	public CatchHelper() {
		
	}
	
	public static void parsePath(String str) {
		//String cmd = "login.do?userName=Tom&password=123456";
		String pattern = "((.*?).do)(//=(.*?))(//=(.*?))";
		//String[] path = str.split("?");
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		if(m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}else {
			System.out.println("NO MATCH");
		}
		
	}
		
}
