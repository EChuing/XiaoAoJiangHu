

function saveSpeedLeftSelect(){
	var speedLeftMenuSelect =  $("#speedLeftMenuSelect option");
	var spId = $("#puriviewSelect").val().split("########")[0];
	var spSpeedLeft = [];
	for(var j in speedLeftMenuSelect){
		for(var i in _speedMenusAll){
			if(_speedMenusAll[i].tabname==getInnerText(speedLeftMenuSelect[j])){
				spSpeedLeft.push(_speedMenusAll[i]);
				
			}
		}
	}
	spSpeedLeft = JSON.stringify(spSpeedLeft);
	showLoading();
	$.post("../updateLeftMenuPurview.action", {
		spId:spId,
		spSpeedLeft:spSpeedLeft,
	}, function(upData) {
		hideLoading();
		if (upData.code < 0) {
			$.messager.alert('通知', '操作失败！原因：' + upData.msg, 'error');
			return;
		}
		upData = upData.body;
		$.post("../selectPurvuceAll.action", {
			spId:spId,
		}, function(data) {
			if (data.code < 0) {
				$.messager.alert('通知', '操作失败！原因：' + data.msg, 'error');
				return;
			}
			data = data.body;
			if(data){
				$("#puriviewSelect").empty();
				for(var i in data){
					if(data[i].spId == spId ){
						$("#puriviewSelect").append("<option selected = 'selected'  value='" + data[i].spId + "########" +data[i].spSpeedLeft.getRealJsonStr() + "'>" + data[i].spName + "</option>");
					}else{
						$("#puriviewSelect").append("<option value='" + data[i].spId + "########" +data[i].spSpeedLeft.getRealJsonStr() + "'>" + data[i].spName + "</option>");
					}
				}
				setSpeedLeftSelect();
				myTips("修改成功！","success");
			}
		}, "json");
	}, "json");
}

