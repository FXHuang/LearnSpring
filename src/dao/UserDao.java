package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import entity.User;

//Dao层原本是连接数据库用的，现在定为处理文件
public interface UserDao {	
	public abstract Map getUserInfo() throws IOException;
	public abstract void addUser(User user) throws IOException;

}
