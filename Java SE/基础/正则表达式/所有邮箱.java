// 获取 所有 邮箱 
class  Demo
{	//	.com	.cn		.com.cn		.net
	public static void main(String[] args) 
	{	String content = "有事联系：1213212313@qq.com"
						+"有事联系：1213212313@iCout.com"
						+"有事联系：ninihao3@qq.cn"
						+"有事联系：121faff3@163.com"
						+"有事联系：1211600h13@qq.com.com"
						+"有事联系：1213212313@qq.cn"
						+"有事联系：1213212313@qq.com"
						+"有事联系：1213212313@qq.net";
		// 正则表达 匹配所有 邮箱 类型
		String reg = "[a-zA-Z1-9]\\w{5,17}@[a-zA-Z0-9]{2,}(\\.(com|cn|net)){1,2}";
		//													\\. 匹配一个 “ . ” 但是 .xxx 这一部分会出现1-2 次
		//把字符串 编译成正则对象
		Pattern p = Pattern.compile(reg);
		//使用正则对象  产生匹配器对象
		Matcher m = p.matcher(content);

		while(m.find()){
			System.out.println(m.group());
		}
	}
}