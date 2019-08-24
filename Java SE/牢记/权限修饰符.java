权限修饰符

public				  公共的				大
protected	pe te ta pe	  受保护的
default    di fo de   缺省 默认			 |
private               私有的				小	

权限修饰符 控制被修饰的成员的范围可见性

			public		protected(保护类)		default(默认)		private 
						
	
同一个类		Y				Y					Y				Y

同一个包		Y				Y					Y				"X
		
子父类			Y				Y					"X				X

不同包			Y				"X					X				X



注意 在不同包下 只有 public 与 protected 可以反问， 但是 protected 必须是在继承关系下才能访问





运算符									结合性
-----------------------------------------------------------

[ ] . ( ) (方法调用)					从左向右
! ~ ++ -- +(一元运算) -(一元运算)	从右向左
* / %									从左向右
+ -										从左向右
<< >> >>>								从左向右
< <= > >= instanceof					从左向右
== !=									从左向右
&										从左向右
^										从左向右
|										从左向右
&&										从左向右
||										从左向右
?:										从右向左
=										从右向左
































