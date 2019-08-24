/*
从键盘输入一个字母组成字符串， 分别统计每个字母出现的次数
要求输出的效果按照字母的顺序
    
			注意要求，结合集合的特性
*/

public class  Demo{

	public static void main(String[] args) {

		System.out.println("请输入一段字符串");
		Scanner scan = new Scanner(System.in);
		String lie = scan.next();
		char[] arr = line.toCharArray();     //字符串 单个存储到数组中
		TreeMap<Character, Intefer> map = new TreeMap<Character, Intefer>();
		for(char c : arr){
			if(map.containsKey(c)) //map 集合是否包含了该字符
				int count = map.get(c);
				map.put(c, count+1);    //统计
			
			}else{ //没包含
				map.put(c,1);
		}
		System.out.println(map);
	}
}
