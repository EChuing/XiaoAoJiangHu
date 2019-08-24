常用方法如下：

1）.public void setAttribute（Sting name, Object value），
设定指定名字的属性的值，并将它添加到session会话范围内，如果这个属性是会话范围内存在，则更改该属性的值。

2）.public Object getAttribute(Stringname)，
在会话范围内获取指定名字的属性的值，返回值类型为object，如果该属性不存在，则返回null。

3）.public void removeAttribute(String name)，
删除指定名字的session属性，若该属性不存在，则出现异常。

4）.public void invalidate（）， in wale dei
使session失效。可以立即使当前会话失效，原来会话中存储的所有对象都不能再被访问。

5）.public String getId( )，
获取当前的会话ID。每个会话在服务器端都存在一个唯一的标示sessionID，session对象发送到浏览器的唯一数据就是sessionID，它一般存储在cookie中。

6）.public void setMaxInactiveInterval(intinterval)，
设置会话的最大持续时间，单位是秒，负数表明会话永不失效。

7）.public int getMaxInActiveInterval（）,
获取会话的最大持续时间。

8）.使用 session 对象的 getCreationTime() 和 getLastAccessedTime()
可以获取会话创建的时间和最后访问的时间，但其返回值是毫秒，一般需要使用下面的转换来获取具体日期和时间。


Session的销毁：

第一：session调用了 session.invalidate()方法.

第二：前后两次请求超出了session指定的生命周期时间. 其中Session的生命周期时间可以在web.xml配置. 默认30分钟