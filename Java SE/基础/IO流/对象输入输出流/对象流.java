import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


 对象流 作用: 
			对象信息的读取和写出
			长久保存

 对象的输出流： ObjectOutputStream .
 
对象的输入流: ObjectInputStream 
 
 
 ObjectOutputStream的使用步骤：
 	1. 
 
 对象输入输出流要注意的细节：											Siri 来ze bou
 	1. 如果对象需要被写出到文件上，那么对象所属的类必须要实现 Serializable 接口。 
		Serializable 接口没有任何的方法，是一个标识接口而已。
 	2. 对象的反序列化创建对象的时候并不会调用到构造方法的、
 	3. serialVersionUID 是用于记录class文件的版本信息的， serialVersionUID 这个数字
		是通过一个类的类名、成员、包名、工程名算出的一个数字。
 	4. 使用ObjectInputStream 反序列化的时候，ObjeectInputStream 会先读取文件中的
		serialVersionUID ，然后与本地的class文件的 serialVersionUID 进行对比，如果这
		两个id不一致，那么反序列化就失败了。
 	5. 如果序列化与反序列化的时候可能会修改类的成员，那么最好一开始就给这个类
		指定一个serialVersionUID，如果一类已经指定的serialVersionUID，然后在序列化与
		反序列化的时候，jvm都不会再自己算这个 class的serialVersionUID了。
 	6. 如果一个对象某个数据不想被序列化到硬盘上，可以使用关键字 transient 修饰。
 	7. 如果一个类维护了另外一个类的引用，那么另外一个类也需要实现 Serializable 接口。
 	
						 (silai sebou) 功能
class Address implements Serializable{
	String country; 
	String city;
	public Address(String country,String city){
		this.country = country;
		this.city = city;
	}
}

class User implements Serializable{
	private static final long serialVersionUID = 1L;
	String userName ;
	String password;
	transient int age;  // transient 透明
	Address address ;
	public User(String userName , String passwrod) {
		this.userName = userName;
		this.password = passwrod;
	}
	public User(String userName , String passwrod,int age,Address address) {
		this.userName = userName;
		this.password = passwrod;
		this.age = age;
		this.address = address;
	}
	public String toString() {
		return "用户名："+this.userName+ " 密码："+ this.password+" 年龄："+this.age+" 地址："+this.address.city;
	}
}

public class Demo {
	public static void main(String[] args) throws IOException, Exception {
		writeObj();
	readObj();
	}
	

	
	//把文件中的对象信息读取出来-------->对象的反序列化
	public static void readObj() throws  IOException, ClassNotFoundException{
		//找到目标文件
		File file = new File("F:\\Tufo\\SDF.txt");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立对象的输入流对象
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		//读取对象信息
		User user = (User) objectInputStream.readObject(); //创建对象肯定要依赖对象所属 的class文件。
		System.out.println("对象的信息："+ user);
	}
	
	
	
	//定义方法把对象的信息写到硬盘上------>对象的序列化。
	public static void writeObj() throws IOException{
		//把user对象的信息持久化存储。
		Address address = new Address("中国","广州");
		User user = new User("admin","123",15,address);
		//找到目标文件
		File file = new File("F:\\Tufo\\SDF.txt");
		//建立数据输出流对象
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		//建立对象的输出流对象
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		//把对象写出
		objectOutputStream.writeObject(user);
		//关闭资源
		objectOutputStream.close();
	}
}