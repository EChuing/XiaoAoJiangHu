 
	  






JSON.stringify()   js值转 JSON

	  

JSON serialize

	JSONUtil.serialize(map)和JSON.toJSONString(map)的区别
	java：
		通过System.out.println()输出	
				JSONUtil.serialize(map)： {"one":"1","two":"null","three":"3","four":"4","five":"5"}
				JSON.toJSONString(map)： {"one":"1","three":"3","four":"4","five":"5"}
		
		'serialize 可以输出为空的内容

	jsp页面

		Js的eval()方法：

		var jsonObj = eval("("+jsonStr+")");

		'如果使用JSONUtil.serialize(map)可以输出空串
		'如果是JSON.toJSONString(map)会报错	
	  
	  
JSON 转换

			String 转 JSON:
                    String index = [{"sucClassId":473 , "sucUserId":169}, {"sucClassId":100 , "sucUserId":153}] ;

                    1.  ->   {"sucClassId":473 , "sucUserId":169}, {"sucClassId":100 , "sucUserId":153}
                        JSONArray jsonArray  =  JSONArray.fromObject(index);     // 将String 转 JSONArray
                        String jsonName1  =  jsonArray.getString(0);             // 去括号
                        String jsonName2  =  jsonArray.getString(1);             // 索引取值
                        System.out.println(jsonName1 + "," + jsonName2);

                    2.  ->    遍历 sucClassId
                        JSONArray json = JSONArray.fromObject(index);
                        for(int i=0;i<json.size();i++) {
                            JSONObject job = json.getJSONObject(i);               // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                            System.out.println(job.get("sucUserId") + "=");       // 取值
                        }


                    将String转为JSONArray  再转为 JSONObject
                    JSONObject.getXXX  可以获取任意类型值

