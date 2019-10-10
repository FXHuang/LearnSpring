package xml;

import entity.User;

public class Testxml {
    public static void main(String[] args) {
        try {
            MySingleIOC ioc = new MySingleIOC("xml/myApplication.xml");
            User user = (User)ioc.getBean("user");                       
            System.out.println(user);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
