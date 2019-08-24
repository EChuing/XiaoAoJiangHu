




-----------------------------------------------------------------
需求：校验一个QQ号
		1. 不能以0 开头
		2. 长度 5~11
		3. 只能有数字组成




public class Demo{
	public static void main(String[] args) {
		String qq = "125720600";
		/*
		if(!qq.startsWith("0")){  // 不 一零开头
			if(qq.length()>=5 && qq.length()<=11){
				//只能由数组组成
				try {
					Long.parseLong(qq);//转换 成 Long 类型数据 若出现字母，就报错
					System.out.println("成功！");
				} catch (Exception e) {
					System.out.println("非法QQ ，只可以由数字组成");
				}
				
				
			}else{
				System.out.println("非法QQ，长度必须5~11 位");
			}
		}else{
			//以0 开头
			System.out.println("非法QQ，QQ不能以0开头");
		}
		*/
		
		//用一句话表上上面所用功能
		System.out.println(qq.matches("[1-9]\\d{4,10}")?"合法QQ":"非法QQ");
		
	}
}
----------------------------------------------------------------------------++
