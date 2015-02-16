<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<script type="text/javascript" src="${basePath}/static/js/jquery-1.11.2.min.js"></script>
	<link rel="stylesheet" href="${basePath}/static/js/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${basePath}/static/js/bootstrap/css/bootstrap-theme.min.css">
	<script src="${basePath}/static/js/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="${basePath}/static/js/bootstrap-datetimepicker/moment-with-locales.js"></script>
	<script type="text/javascript" src="${basePath}/static/js/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
	
	<link rel="stylesheet" href="${basePath}/static/js/jquery-ui/css/custom-theme/jquery-ui-1.10.0.custom.css">
  	<script src="${basePath}/static/js/jquery-ui/jquery-ui.min.js"></script>
  	
  	<script src="${basePath}/static/js/lhgdialog/lhgdialog.min.js"></script>
  	
	<script type="text/javascript">
		$(function() {
			$("#form_createTime").datetimepicker({
				locale: 'zh-cn',
				format: 'YYYY-MM-DD HH:mm:ss'
			});
		});
	
		function btnEdit(idx) {
			var index = $("#td\\[" + idx + "\\]\\.index").text();
			var gameId = $("#td\\[" + idx + "\\]\\.gameId").text();
			var gameName = $("#td\\[" + idx + "\\]\\.gameName").text();
			var bookSize = $("#td\\[" + idx + "\\]\\.bookSize").text();
			var createTime = $("#td\\[" + idx + "\\]\\.createTime").text();
			$("#form_gameId").val(gameId);
			$("#form_gameName").val(gameName);
			$("#form_bookSize").val(bookSize);
			$("#form_createTime").val(createTime);
			$('#myModal').modal();
		}
		
		function btnSave() {
			var $form = $("#myModal form:first");
			$.ajax({
				url: "${basePath}/home/save",
			  	data: $form.serializeArray(),
			  	dataType: "json",
			  	success: function(data) {
			  		if(data.code && data.code == 'SUCCESS') {
			  			$.dialog.alert('操作成功！',refresh);
			  		} else {
			  			$.dialog.alert('操作失败！',refresh);
			  		}
			  		function refresh() {
			  			location.reload();
			  		}
			  	}
			});
		}
		
		function btnDel(idx) {
			var gameId = $("#td\\[" + idx + "\\]\\.gameId").text();
			$.dialog.confirm('确定要删除？', function(){
				$.dialog.tips('执行确定操作');
			    $.ajax({
					url: "${basePath}/home/del/" + gameId,
				  	dataType: "json",
				  	success: function(data) {
				  		if(data.code && data.code == 'SUCCESS') {
				  			$.dialog.alert('操作成功！',refresh);
				  		} else {
				  			$.dialog.alert('操作失败！',refresh);
				  		}
				  		function refresh() {
				  			location.reload();
				  		}
				  	}
				});
			}, function(){
			     $.dialog.tips('执行取消操作');
			});
		}
		
		function logout() {
			$.dialog.confirm('确定要注销？', function(){
			    $.dialog.tips('执行确定操作');
			}, function(){
			    $.dialog.tips('执行取消操作');
			});
		}
		
		function addRecord() {
			$("#form_gameId").val('');
			$("#form_gameName").val('');
			$("#form_bookSize").val('');
			$("#form_createTime").val('');
			$('#myModal').modal();
		}

	</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">推荐位后台管理系统</a>
					</div>
					<ul class="nav navbar-nav">
						<li><a href="#">aaa</a></li>
						<li><a href="#">aaa</a></li>
						<li><a href="#">aaa</a></li>
						<li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#">Action</a></li>
				            <li><a href="#">Another action</a></li>
				            <li><a href="#">Something else here</a></li>
				            <li class="divider"></li>
				            <li><a href="#">Separated link</a></li>
				          </ul>
				        </li>
					</ul>
					<form class="navbar-form navbar-right">
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" onclick="logout()">退出</button>
					</form>
				</div>
			</nav>
		</div>
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">Library</a></li>
			  	<li><a href="#">Home</a></li>
			  	<li class="active">Data</li>
			</ol>
		</div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="glyphicon glyphicon-plus" aria-hidden="true" onclick="addRecord()"></span></th>
						<th>游戏编号</th>
						<th>游戏名称</th>
						<th>预定数量</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<#list gameInfoList as gameInfo>
					<tr>
						<td id="td[${gameInfo_index}].index">${gameInfo_index}</td>
						<td id="td[${gameInfo_index}].gameId">${gameInfo.gameId}</td>
						<td id="td[${gameInfo_index}].gameName">${gameInfo.gameName}</td>
						<td id="td[${gameInfo_index}].bookSize">${gameInfo.bookSize}</td>
						<td id="td[${gameInfo_index}].createTime">${gameInfo.createTime?datetime}</td>
						<td>
							<button type="button" class="btn btn-info btn-xs" data-toggle="modal" onclick="btnEdit(${gameInfo_index});">编辑</button>
							<button type="button" class="btn btn-info btn-xs" data-toggle="modal" onclick="btnDel(${gameInfo_index});">删除</button>
						</td>
					</tr>
				</#list>
				</tbody>
			</table>
			<nav>
				<div class="text-center">
				<ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				  </div>
			</nav>
		</div>

		<!-- //Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">游戏详情</h4>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="">游戏编号</label>
								<input id="form_gameId" name="gameId" type="text" class="form-control" value="" readonly/>
							</div>
							<div class="form-group">
								<label for="">游戏名称</label>
								<input id="form_gameName" name="gameName" type="text" class="form-control" value="" />
							</div>
							<div class="form-group">
								<label for="">预定数量</label>
								<input id="form_bookSize" name="bookSize" type="number" class="form-control" value="" />
							</div>
							<div class="form-group">
								<label for="">创建时间</label>
								<div class='input-group date' id='datetimepicker1'>
				                	<input id="form_createTime" name="createTime" type='text' class="form-control" value=""/>
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="btnSave()">保存</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Model// -->
		
	</div>
</body>
</html>