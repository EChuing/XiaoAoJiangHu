字符流	
	扩展功能 newLiine  行		

输出流
	可以用 flush （Fla xu）


		字节						字符
输出流 
		OutputStream				Writer
			|FileOutputStream			|FileWriter
			|BufferedOutputStream		|BufferedWriter

write()  输出括号中的数据 内部有8k缓冲数组存满时 才会转 到硬盘中
flush()  刷新    可以将存储到内存的临时数据 存进硬盘中
close()

newLine() (字符流特有)   行输出数据   其实内部多了个\r\n的语句

换行
	newLine()  ==	write("\r\n"); 


字符流自带解码功能 不用类型转换？

输入流
		InputStream					Reader
			|FileInputStream			|FileReader
			|BufferedInputStream		|BufferedReader   能行读入


read()			读到末尾 返回 -1	   一个数据    char 类型
close()

readLine()（字符流特有）读到末尾 返回 null   行读入






read(x)	  输入流  的  读取数据  将读到的数据存到 x 中   
write(x)  输出流 的  写出数据  根据X的内容写出数据   注意长度





输入字节流		（InputStream）
	找到目标文件
	File file = new File();
	建立数据输入通道
	FileInputStream fileInputStream = new FileInputStream();
	建立缓冲输入字节流通道
	BufferedOutputStream bufferedInputStream = new BufferedInputStream();
	读取文件			
			while( bufferedInputStream.read())!= -1
	关闭资源
	bufferedOutputStream.close（）；


	//read()方法返回读入缓冲区的字节数，如果数据读完了就返回-1
	//close()  关闭



输出字节流		（OutputStream）
	找到目标文件
	File file = new File();
	建立数据输出通道
	FileOutputStream fileOutputStream = new FileOutputStream();
	建立缓冲输出数组通道
	BufferedOutputStream bufferOutputStream = new BufferedOutputStream();
	把文件数据写入	（外 的）
	bufferedOutputStream.write（"Hello world". getBytes()）；
	关闭资源
	bufferedPutputStream.flush 或 .close


输入字符流		（Reader）	（V de）
	目标文件
	File file = new File();
	建立数据输入通道
	FileReader fileReader = new FileReader();
	建立缓冲字符输入通道
	BufferedReader bufferedReader = new BufferedReader();
	读取数据
	bufferedReader.read();      一个字符度读取
	while (line = bufferedReader.readLine())!=null  一行字符的读取
	关闭资源
	bufferedReader.close();

	

输出字符流		（Writer）    （歪 te）
	找到目标文件
	File file = new File();
	建立数据的输出通道
	FileWriter fileWriter = new FileWriter();
	建立缓冲数据输出通道
	BufferedWriter bufferedWriter = new BufferedWriter();
	写入数据（fai e 歪de.外 的）
	bufferedWriter.write();		写入数据		
	bufferedWriter.newLine();	换行
	关闭资源
	bufferedWriter.close(); 或 flush



