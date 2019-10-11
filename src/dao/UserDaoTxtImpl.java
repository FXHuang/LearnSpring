package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entity.User;
import service.UserService;

// Dao实现类
public class UserDaoTxtImpl implements UserDao {

	private String userFilePath = "d:/user.txt";

	@Override
	public Map getUserInfo() throws IOException {
		Map<String, String> userInfoMap = new HashMap<>();
		Scanner scanner = new Scanner(new File(userFilePath));
		while (scanner.hasNextLine()) {
			String userRecord = scanner.nextLine();
			String[] str = userRecord.split(" "); //是否有异常
			userInfoMap.put(str[0],str[1]);		
			if (userRecord.equals("")) {
				continue;
			}
		}
		return userInfoMap;
	}

	@Override
	public void addUser(User user) throws IOException {
		File file = new File(userFilePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			
			fileWriter.append(UserService.toRecordString(user));
			fileWriter.append('\n');
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
