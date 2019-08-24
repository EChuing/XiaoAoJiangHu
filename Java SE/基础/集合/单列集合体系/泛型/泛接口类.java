package cn.itcast.genrictiry;


 泛型接口
 
泛型接口的定义格式: 
	(intfei si   接口)
	interface 接口名<声明自定义泛型>{     //在接口名 后面加 < >
	
	}

泛型接口要注意的事项：
	1. 接口上自定义的泛型的具体数据类型是在实现一个接口的时候指定 的。
	2. 在接口上自定义的泛型如果在实现接口的时候没有指定具体的数据类型，那么默认为Object类型。
	
需求： 目前我实现一个接口的时候，我还不明确我目前要操作的数据类型，我要等待创建接口实现类 对象的时候我才能指定泛型的具体数据类型。
	
	如果要延长接口自定义泛型 的具体数据类型，那么格式如下：
	格式：  
		public class Demo4<T> implements Dao<T>{
							( inpeman si   实现了  )
		}
	


interface Dao<T>{  // 自定义 泛接口类
	
	public void add(T t);	
}

public class Demo4<T> implements Dao<T> {    // 延迟接口定义

	public static void main(String[] args) {
		Demo4<String> d = new Demo4<String>();   //使得 T 延迟到创建  d 的时再定义
	}

	public void add(T t){
		
	}


}
