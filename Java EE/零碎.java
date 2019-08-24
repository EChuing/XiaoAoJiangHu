onkeyup		松开键盘触发
onkeydown	按下键盘触发

replace 字符串替换方法






文本框 只能数组不带小数点
<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" name="numSort">  
		只能数组带小数点
<input type="text" onkeyup="value=value.replace(/[^\d\.]/g,'')" name="numSort">  




onkeyup="value=value.replace"