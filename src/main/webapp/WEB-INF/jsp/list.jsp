<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>  
<html>  
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理</title>
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css">
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="datagrid-filter.js"></script>
	<script type="text/javascript">
		var url;
		//新增用户，打开对话框，指定url为add
		function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','新增用户');
			$('#fm').form('clear');
			url = 'add';
		}
		//修改选中行，打开对话框，指定url为update加上对应id
		function editUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','更新用户');
				//将选中行的数据加载到表单
				$('#fm').form('load',row);
				url = 'update/' + row.id;
			}
		}
		//提交表单到对应url
		function saveUser(){
			$('#fm').form('submit',{
				url: url,
				success: function(result){
					//json字符串转对象
					var res = eval('('+result+')');
					//成功则关闭对话框并刷新数据
					if (res.success){
						$('#dlg').dialog('close');
						$('#dg').datagrid('reload');
					} 
					//提示
					$.messager.show({
						title: '提示',
						msg: res.msg
					});
				}
			});
		}
		//移除选中行
		function removeUser(){
			var row = $('#dg').datagrid('getSelected');
			if(row){
				//消息框
				$.messager.confirm('Confirm','Are you sure you want to remove this user?',function(r){
					//点击确认
					if(r){
						$.post('delete',{id:row.id},function(result){
							var res = eval('('+result+')');
							if (res.success){
								//重新加载该页数据
								$('#dg').datagrid('reload');
							}
							$.messager.show({
								title: '提示',
								msg: res.msg
							});
						});
					}
				});
			}
		}
		//按条件筛选
		function searchFilter(){
			var search_account = $('#search_account').val();
			var search_name = $('#search_name').val();
			//传递筛选条件重新加载
			$('#dg').datagrid('load',{
				search_name: search_name,
				search_account: search_account
			});
        }
		
	</script>
</head>
<body>
	<h2>用户管理系统</h2>
	<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
	<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:400px;"
			url="getUsers"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">ID</th>
				<th field="account" width="50">账号</th>
				<th field="name" width="50">姓名</th>
				<th field="phone" width="50">手机</th>
				<th field="email" width="50">邮箱</th>
				<th field="address" width="50">地址</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<!-- 增、改、删按钮 -->
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">移除</a>
		<!-- 筛选工具栏 -->
		<div>
			<label>账号</label> 
			<input id="search_account" class="easyui-textbox" label="Search:" labelPosition="left">&nbsp;
			<label>姓名</label>
			<input id="search_name" class="easyui-textbox" label="Search:" labelPosition="left">&nbsp;
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchFilter()">筛选</a>
		</div>
	</div>
	<!-- 对话框，用来填写用户信息和提交，buttons指定按钮组 -->
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>账号:</label>
				<input name="account" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>姓名:</label>
				<input name="name" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>手机:</label>
				<input name="phone" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>邮箱:</label>
				<input name="email" class="easyui-validatebox" validType="email">
			</div>
			<div class="fitem">
				<label>住址:</label>
				<input name="address">
			</div>
		</form>
	</div>
	<!-- 提交和取消按钮 -->
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</body>
</html> 