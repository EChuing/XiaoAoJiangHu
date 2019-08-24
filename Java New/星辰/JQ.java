 
	
	'查询数据 都返回data.body里，  添加自定义数据
			$.post("../queryHouseStore.action", {

			},function(data){

				data=data.body
				data = data.body;
				for(var i in data){
					//遍历添加自定义字符段
					data[i].addDetailed = data[i].hsAddDistrict+' '+data[i].hsAddCommunity+' '+data[i].hsAddDoorplateno
				}
				console.log("============================")   
				console.log(data)   '看输出结果 只输出data，不能加符合 
				$('#addSeatDlg').dialog("open");
				$("#addSeatRuleDiv1").datagrid("loadData",data);
			})





'取 cocAddress 里的 address":"地址

		0:{
			AddressG: "dsfsdf"
			cocAddress: ""{"address":"地址","community":"市区"}""
			cocCompany: ""
			cocCompanyAbbreviation: ""
			cocContacts: "zzz"
			totalNum: "9"
			__proto__: Object
			}	
		1: {cocCompany: "", cocUrl: "", cocScale: "10人以内", cocInternalCredit: "", cocState: "", …}
		2: {cocCompany: "", cocUrl: "", cocScale: "", cocInternalCredit: "", cocState: "", …}


				console.log(data.body)
				var addre1 = [];
				for(var i in data.body){ 
					addre1[i] =JSON.parse(data.body[i].cocAddress.getRealJsonStr()); "{"address":"地址","community":"市区"} "...
					data.body[i].cocAddress = addre1[i].address
					//addre1 = JSON.parse(data.body[i].cocAddress);
				}

				console.log(data.body);

				//去掉JSON字符串头尾的双引号（public.js里也有，写这里是为了防止public还没加载完，调用getRealJsonStr函数会报错）
'					String.prototype.getRealJsonStr = function(){
					return this.substring(1,this.length-1)
				};