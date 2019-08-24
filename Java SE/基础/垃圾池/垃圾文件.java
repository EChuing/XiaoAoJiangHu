public class Deme{
	
	public static void main(String[] args){
		File file = new File("路径");
		
		listFile(file);
	}

	public static void listFile(File dir){
		File[] file = dir.listFiles();//获取所有的子文件
		System.out.println("文件：");
		for(File fileItem : files){
			if(fileItem.isFile()){
				System.out.println("\t"+fileItem.getName());
			
			}
		
		}
	
	
	
	
	}
}




exists		文件或文件夹是否存在
isFile		是否同一个文件，默认false
isDirectory	是否同一个目录，默认fales
isHidden	是否是一个隐藏文件或隐藏目录
isAbsolute	测试此抽象路径名是否为绝对路径名





字节流
newLLine 

flush

输出流
OutputStream 
	FileOutputStream
	BufferedOutputStream


输入流
InputStream

<html>
	<table align=center>
		
		<tr>
			<td>用户名</td><td><input align=center type="text"/></td>
		</tr>

		<tr>
			<td>密码</td><td><input align="center" type="password"/></td>
		</tr>
		
		<tr>
			<td>年龄</td><td><input width="300px" type="text"/></td>
		</tr>
		<tr>
			<td>地址</td><td><input type="text"/></td>
		</tr>

		<tr>
			<td>毕业学校</td>
		</tr>

		<tr>
			<td>户籍</td>
		</tr>

		<tr>
			<td>性别</td>
		</tr>




	</table>

</html>