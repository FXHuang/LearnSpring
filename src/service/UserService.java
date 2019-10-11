package service;

import entity.User;

// 处理请求
public class UserService {

	public static String toRecordString(User user) {
		return String.format("%s %s", user.getName(), user.getPassword());
	}

	public boolean isLogin() {
		boolean flag = false;

		return flag;

	}

	public void register() {

	}

	public void login() {

	}

	public void addMoney(User user , int addmoney) {
		user.setMoney(user.getMoney() + addmoney);
	}

	public void transfer(User user, int transmoney) {

		if (!(user.getMoney() < transmoney)) {
			user.setMoney(user.getMoney() - transmoney);
		} else {
			System.out.println("转账失败，余额不足");
		}
	}

}
