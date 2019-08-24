

基本对话  http://www.jeasyui.net/demo/519.html

基本标签  http://www.jeasyui.net/demo/557.html
基本DataGrid  http://www.jeasyui.net/demo/331.html
EasyUI创建对话框  http://www.jeasyui.net/tutorial/50.html




"弹框============================================"
   $("#ID").dialog({
        title: "启用设备",
        top: getTop(100),
        left: getLeft(800),
        width: 600,
        height: 400,
        closed: true,
        cache: false,
        modal: true,
        onClose: function () {
            // $('.xwtable span').text('');
        }


"表格数据回显============================================"
$("#idGrid").datagrid("loadData", data);
"弹框显示============================================"
 $("#idDlg").dialog("open");
"获取所有行============================================"
 var row = $('#idGrid').datagrid('getRows');
"复选框获取选中行============================================"
  var rowChe = $("#enableStateGrid").datagrid("getChecked")