package xml;

import java.util.Scanner;


/*
 * 1.main函数唤起命令行（命令行充当浏览器）

2.命令行输入 login.do?userName=Tom&password=123456 后回车，提示 抱歉，Tom未注册

3.命令行输入 register.do?userName=Tom&password=123456 后回车，提示Tom注册成功，欢迎您的加入

4.命令行输入 login.do?userName=Tom&password=123456 后回车，提示 登录成功，欢迎您，Tom！

5.命令行输入 deposit.do?money=100 后回车，提示 您已成功充值100元

6.命令行输入 pay.do?money=100 后回车，提示 您已成功付款100元 
 * 
 */

import entity.User;
import util.CatchHelper;

public class Testxml {
	
	
	public static CatchHelper helper;   //这里的hepler也要bean容器托管
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 从键盘接收数据
		// 判断是否还有输入
		if (scan.hasNextLine()) {
			String strcmd = scan.nextLine();
			helper = new CatchHelper();
			helper.parsePath(strcmd);
		}
		scan.close();
		
	}

}
