package entity;

// 实体类，姓名，密码，余额   密码这么设置明显有问题，没想到更好的办法
public class User{
    private String name;
    private String password;
    private int money;

    @Override
    public String toString() {    	
        return "User{"+
                "name='" + name + 
                "',money='" + money + '\''+
                "}";
    }    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void addMoney(int addmoney) {
		this.money += addmoney;
	}
	
	public int trans(int transmoney) {
		// TODO Auto-generated method stub
		if(!(this.money<transmoney)) {
			this.money -= transmoney;
			return this.money;
		}else {
			System.out.println("转账失败，余额不足");
			return -1;
		}
	}
}
