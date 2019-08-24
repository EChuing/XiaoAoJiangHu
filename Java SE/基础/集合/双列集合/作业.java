package cn.itcast;

import java.util.TreeMap;



定义一个TreeMap ,键存储的是 书 对象，只存储的是字符串。根据书的出版日期排序



class Book implements Comparable<Book>{
	
	String name;
	String date;
	
	public Book(String name, String date){
		
		super();
		this.name = name;
		this.date = date;
	}
	
	//利用字符串的 CompareTo 方法
	public int compareTo(Book o){
		
		return this.date.compareTo(o.date);
	}
	
	
	
	public String toString(){
		return "{书名："+this.name+",日期："+this.date+"}";
	}
	
}

public class Demo{
	
	public static void main(String[] args){
		
		TreeMap<Book,String> map = new TreeMap<Book,String>();  // 值存储书名
		map.put(new Book("红楼梦","1990-12-03"),"001");
		map.put(new Book("三国演义","1997-10-04"),"004");
		map.put(new Book("水浒传","1989-04-03"),"003");
		map.put(new Book("西游记","1993-08-13"),"002");
		System.out.println(map);
	}
	
}