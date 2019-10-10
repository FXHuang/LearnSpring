package dao;

import entity.User;

//Dao层原本是连接数据库用的，现在定为处理文件
public interface UserDao {
	
	public abstract void regist(User user);
	
	public abstract boolean isLogin(String username,String password);

}
