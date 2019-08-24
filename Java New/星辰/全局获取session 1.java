
前端session 赋值


<input id="loginDataType" type="hidden" value='<%=session.getAttribute("dataType")%>'>

var _loginDataType =$('#loginDataType').val();


















































一
	'全局获取Session的值   不行就用下面的
			HttpServletRequest request = ServletActionContext.getRequest();
			String dataType = (String) request.getSession().getAttribute("dataType");  
								这里返回的类型要和实体类的一致（"dataType"） 















二
	'SessionUtil.java
		public class SessionUtil {

			/**
			 * 获取session的值
			 * @param attribute
			 * @return
			 */
			public static String getSession(String attribute){
				HttpServletRequest request = ServletActionContext.getRequest();
				return (String) request.getSession().getAttribute(attribute);
			}
			
			
			//SessionUtil.getSession("值")    这样调用获取
		}
	'ServletActionContext.class
		public static HttpServletRequest getRequest() {
			return (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
		}